package persistence;

import domain.Invoice;

public interface Database {

  void saveInvoice(Invoice invoice);

  void getInvoiceById(Invoice invoice);

  void getInvoices(Invoice invoice);

  void updateInvoice(Invoice invoice);

}