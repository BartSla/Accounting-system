package pl.coderstrust.persistence;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import pl.coderstrust.domain.Invoice;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "inMemory")
public class InMemoryDatabase implements Database {

    private List<Invoice> invoices;

    public InMemoryDatabase() {
        this.invoices = new ArrayList<>();
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        if (invoice != null) {
            invoices.add(invoice);
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return invoices.get(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        for (Invoice invoiceToFind : invoices) {
            if (invoiceToFind.getId() == invoice.getId()) {
                int index = invoices.indexOf(invoiceToFind);
                invoices.set(index, invoice);
            }
        }
    }

    @Override
    public void removeInvoice(int id) {
         invoices.remove(id);
    }

    @Override
    public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
        List<Invoice> invoicesInDateRange = new ArrayList<>();
        for (Invoice toFind : invoices) {
            if ((toFind.getDate().isAfter(fromDate) || toFind.getDate().isEqual(fromDate))
                    && toFind.getDate().isBefore(toDate) || toFind.getDate().isEqual(toDate)) {
                invoicesInDateRange.add(toFind);
            }
        }
        return invoicesInDateRange;
    }
}