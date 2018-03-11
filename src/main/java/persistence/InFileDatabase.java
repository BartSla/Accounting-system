package persistence;

import domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InFileDatabase implements Database {

    private List<Invoice> invoices = new ArrayList<>();
    private FileHelper filehelper = new FileHelper();
    private ObjectMapperProvider mapper = new ObjectMapperProvider();

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            try {
                String jsonInString = mapper.mapperProvider().writeValueAsString(invoice);
                filehelper.writeValueAsStringInFile(jsonInString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        try {
            List<String> stringInvoices = filehelper.readValueFromJsonString();
            for (String item : stringInvoices) {
                invoices.add(mapper.mapperProvider().readValue(item, Invoice.class));
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
                invoiceById = getAllInvoices().get(id);
            }
        }
        return invoiceById;
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        for (Invoice invoiceById : getAllInvoices()) {
            if (invoiceById.getId() == invoice.getId()) {
                getAllInvoices().remove(invoiceById);
                getAllInvoices().add(invoice);
                filehelper.deleteFile();
            }
            saveInvoice(invoiceById);
        }
    }

    @Override
    public void removeInvoice(int id) {
        for (Invoice invoiceForLoop : getAllInvoices()) {
            if (invoiceForLoop.getId() == id) {
                getAllInvoices().remove(id);
            }
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