package processing;

import domain.Invoice;
import persistence.Database;

public class InvoiceBook {

  Database database = new InMemoryDatabase();

  public void addNewInvoice(Invoice invoice) {
    database.saveInvoice(invoice);
  }

  public void getInvoiceById(int id) {
    database.getInvoiceById(id);
  }

  public void getAllInvoices() {
    database.getInvoices();
  }

  private void removeInvoice(int id) {
    database.removeInvoiceById(id);
  }

  public void updateInvoice(Invoice invoice) {
  }
}