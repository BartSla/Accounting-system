package pl.coderstrust.processing;

import org.springframework.stereotype.Service;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceBook {

  private Database database;

  public InvoiceBook(Database database) {
      this.database = database;
  }

  public void addNewInvoice(Invoice invoice) {
    database.saveInvoice(invoice);
  }

  public void removeInvoice(int id) {
    database.removeInvoice(id);
  }

  public Invoice getInvoiceById(int id) {
    return database.getInvoiceById(id);
  }

  public List<Invoice> getAllInvoices() {
    return database.getAllInvoices();
  }

  public void updateInvoice(Invoice invoice) {
    database.updateInvoice(invoice);
  }

  public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
    return database.getAllInvoicesInDateRange(fromDate, toDate);
  }
}