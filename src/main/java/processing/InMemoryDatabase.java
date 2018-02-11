package processing;

import domain.Invoice;
import persistence.Database;

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
  public void getInvoices() {

    invoices.toArray();
  }


  @Override
  public void getInvoiceById(int id) {
    invoices.get(id);
  }

  @Override
  public void updateInvoice(Invoice invoice) {
    if (!invoices.contains(invoice)) {
      invoices.set(invoice.getId(), invoice);
    }
  }
}