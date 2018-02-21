package persistence;

import domain.Invoice;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

public interface Database {

  void saveInvoice(Invoice invoice);

  List<Invoice> getInvoices();

  Invoice getInvoiceById(int id);

  void updateInvoice(Invoice invoice);

  void removeInvoice(Invoice invoice);

  List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate);
}