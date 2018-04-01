package pl.coderstrust.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import pl.coderstrust.domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "inFile")
public class InFileDatabase implements Database {


    private static final Logger logger = LoggerFactory.getLogger(InFileDatabase.class);

    private FileHelper fileHelper;
    private ObjectMapper mapper;

    @Autowired
    public InFileDatabase(ObjectMapper mapper, FileHelper fileHelper) {
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
                logger.error("Couldn't save invoice in file", e);
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
            logger.error("Couldn't read all invoices from file", e);
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
            if (!invoice.getDate().isBefore(fromDate) && !invoice.getDate().isAfter(toDate)) {
                invoicesInDateRange.add(invoice);
            }
        }
        return invoicesInDateRange;
    }
}