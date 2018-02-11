package persistence;

import domain.Invoice;

public interface Database {

  void saveInvoice(Invoice invoice);

  void getInvoices();

  void getInvoiceById(int id);

  void updateInvoice(Invoice invoice);

  void removeInvoice(Invoice invoice);

  void removeInvoiceById(int id);
}