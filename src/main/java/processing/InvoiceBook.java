package processing;

import domain.Invoice;
import persistence.Database;
import persistence.InMemoryDatabase;

import java.time.LocalDate;

public class InvoiceBook {

  Database database = new InMemoryDatabase();

  public void addNewInvoice(Invoice invoice) {
    database.saveInvoice(invoice);
  }

  public void removeInvoice(Invoice invoice) {
    database.removeInvoice(invoice);
  }

  public void getInvoiceById(int id) {
    database.getInvoiceById(id);
  }

  public void getAllInvoices() {
    database.getInvoices();
  }

  public void updateInvoice(Invoice invoice) {
    database.updateInvoice(invoice);
  }

  public void getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate){
    database.getAllInvoicesInDateRange(fromDate, toDate);
  }
}