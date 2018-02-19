package persistence;

import domain.Invoice;

import java.util.ArrayList;
import java.util.List;


public class InMemoryDatabase implements Database {

    private List<Invoice> invoices = new ArrayList<>();

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            invoices.add(invoice);
        }
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return invoices.get(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        if (!invoices.contains(invoice)) {
            invoices.set(invoice.getId(), invoice);
        }
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        for (Invoice invoiceToFind : invoices) {
            if (invoiceToFind.getId() == invoice.getId()) {
                int index = invoices.indexOf(invoiceToFind);
                invoices.set(index, invoice);
            }
        }
    }
}