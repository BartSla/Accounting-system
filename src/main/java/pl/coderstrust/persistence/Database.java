package pl.coderstrust.persistence;

import pl.coderstrust.domain.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface Database {

  void saveInvoice(Invoice invoice);

  List<Invoice> getAllInvoices();

  Invoice getInvoiceById(int id);

  void updateInvoice(Invoice invoice);

  void removeInvoice(int id);

  List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate);
}