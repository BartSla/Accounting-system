package persistence;

import config.ObjectMapperProvider;
import domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InFileDatabase implements Database {

    //FIXME: this should be injected in constructor - not initialized in place. Please also rename to proper camel case: `fileHelper`
    private FileHelper filehelper = new FileHelper();
    /** FIXME: this is wrong: you should have here ObjectMapper, not ObjectMapperProvider
     * - Spring will deal with it correctly itself if only you inject it in constructor, not initialize in place.
     */
    private ObjectMapperProvider mapper = new ObjectMapperProvider();

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            try {
                /** FIXME: as written above: you should already have ObjectMapper in here
                 * - the `objectMapper()` method from the ObjectMapperProvider is never to be called explicitelly by you in the code
                 * - it is only for Spring usage (it will call it in the background) **/
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
                //FIXME: as above - do not call objectMapper() method on your own
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
        //TODO: this is ok, but may be clearer by using different variable names. I suggest: `existingInvoice` instead of `invoiceById` and `updatedInvoice` instead of `invoice`
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
        //TODO: same here - name `invoiceById` is somehow confusing - I would suggest `existingInvoice` or just `invoice`
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
            //TODO: this is unreadable - you can change this two `ifs` to just one:
            /**
             * if(!invoice.getDate.isBefore(fromDate) && !invoice.getDate.isAfter(toDate)){
             */
            if (invoice.getDate().isAfter(fromDate) || invoice.getDate().isEqual(fromDate)) {
                if (invoice.getDate().isBefore(toDate) || invoice.getDate().isEqual(toDate)) {
                    invoicesInDateRange.add(invoice);
                }
            }
        }
        return invoicesInDateRange;
    }
}