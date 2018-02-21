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
<<<<<<< HEAD:src/main/java/processing/InMemoryDatabase.java
  public void removeInvoice(Invoice invoice) {
    if (invoices.contains(invoice)) {
      invoices.remove(invoice);
    }
  }

  @Override
  public void removeInvoiceById(int id) {
    if (id >= 0 && id < invoices.size()) {
      invoices.remove(invoices.get(id));
    }
  }

  @Override
  public List<Invoice> getInvoices() {

=======
  public List<Invoice> getInvoices() {
>>>>>>> development:src/main/java/persistence/InMemoryDatabase.java
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
    if (invoices.contains(invoice)) {
      invoices.remove(invoice);
    }
  }
}