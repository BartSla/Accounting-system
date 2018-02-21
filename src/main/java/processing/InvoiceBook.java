package processing;

import domain.Invoice;
import persistence.Database;
import persistence.InMemoryDatabase;

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

  public void updateInvoice(Invoice invoice) {
  }
}