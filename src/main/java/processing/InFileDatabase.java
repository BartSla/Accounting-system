package processing;

import domain.Invoice;
import persistence.Database;

import java.util.List;

public class InFileDatabase implements Database {

  @Override
  public void saveInvoice(Invoice invoice) {
  }

  @Override
  public List<Invoice> getInvoices() {return null;
  }

  @Override
  public Invoice getInvoiceById(int id) {
    return null;
  }

  @Override
  public void updateInvoice(Invoice invoice) {
  }

  @Override
  public void removeInvoice(Invoice invoice) {
  }

  @Override
  public void removeInvoiceById(int id) {
  }
}
