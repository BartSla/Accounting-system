package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InFileDatabase implements Database {
    
    private FileHelper fileHelper;
    private ObjectMapper mapper;

    @Autowired
    public InFileDatabase (ObjectMapper mapper, FileHelper fileHelper){
        this.fileHelper = fileHelper;
        this.mapper = mapper;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            try {
                String jsonInString = mapper.writeValueAsString(invoice);
                fileHelper.writeStringInFile(jsonInString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        try {
            List<String> stringInvoices = fileHelper.readInvoicesStringsFromFile();
            for (String item : stringInvoices) {
                invoices.add(mapper.readValue(item, Invoice.class));
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
        fileHelper.deleteFile();
        for (Invoice existingInvoice : invoices) {
            if (existingInvoice.getId() == invoice.getId()) {
                saveInvoice(invoice);
                continue;
            }
            saveInvoice(existingInvoice);
        }
    }

    @Override
    public void removeInvoice(int id) {
        List<Invoice> invoices = getAllInvoices();
        fileHelper.deleteFile();
        for (Invoice existingInvoice : invoices) {
            if (existingInvoice.getId() == id) {
                continue;
            }
            saveInvoice(existingInvoice);
        }
    }

    @Override
    public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
        List<Invoice> invoicesInDateRange = new ArrayList<>();
        for (Invoice invoice : getAllInvoices()) {
            if(!invoice.getDate().isBefore(fromDate) && !invoice.getDate().isAfter(toDate)){
                invoicesInDateRange.add(invoice);
            }
        }
        return invoicesInDateRange;
    }
}