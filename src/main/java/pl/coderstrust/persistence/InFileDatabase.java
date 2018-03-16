package pl.coderstrust.persistence;

import pl.coderstrust.config.ObjectMapperProvider;
import pl.coderstrust.domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InFileDatabase implements Database {

    private FileHelper filehelper = new FileHelper();
    private ObjectMapperProvider mapper = new ObjectMapperProvider();

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            try {
                String jsonInString = mapper.objectMapper().writeValueAsString(invoice);
                filehelper.writeValueAsStringInFile(jsonInString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        try {
            List<String> stringInvoices = filehelper.readValueFromJsonString();
            for (String item : stringInvoices) {
                invoices.add(mapper.objectMapper().readValue(item, Invoice.class));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Invoice invoiceById = new Invoice();
        for (Invoice invoice : getAllInvoices()) {
            if (invoice.getId() == id) {
                invoiceById = invoice;
            }
        }
        return invoiceById;
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        List<Invoice> invoices = getAllInvoices();
        filehelper.deleteFile();
        for (Invoice invoiceById : invoices) {
            if (invoiceById.getId() == invoice.getId()) {
                saveInvoice(invoice);
                continue;
            }
            saveInvoice(invoiceById);
        }
    }

    @Override
    public void removeInvoice(int id) {
        List<Invoice> invoices = getAllInvoices();
        filehelper.deleteFile();
        for (Invoice invoiceById : invoices) {
            if (invoiceById.getId() == id) {
                continue;
            }
            saveInvoice(invoiceById);
        }
    }

    @Override
    public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
        List<Invoice> invoicesInDateRange = new ArrayList<>();
        for (Invoice invoice : getAllInvoices()) {
            if (invoice.getDate().isAfter(fromDate) || invoice.getDate().isEqual(fromDate)) {
                if (invoice.getDate().isBefore(toDate) || invoice.getDate().isEqual(toDate)) {
                    invoicesInDateRange.add(invoice);
                }
            }
        }
        return invoicesInDateRange;
    }
}