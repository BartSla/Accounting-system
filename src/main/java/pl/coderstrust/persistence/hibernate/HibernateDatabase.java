package pl.coderstrust.persistence.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;

@Repository
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "hibernate")
public class HibernateDatabase implements Database {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public void saveInvoice(Invoice invoice) {
    if (invoice != getInvoiceById(invoice.getId())) {
      invoiceRepository.save(invoice);
    }
  }

  @Override
  public List<Invoice> getAllInvoices() {
    List<Invoice> invoiceList = new ArrayList<>();
    invoiceRepository.findAll().forEach(invoiceList::add);
    return invoiceList;
  }

  @Override
  public Invoice getInvoiceById(int id) {
    return invoiceRepository.findOne(id);
  }

  @Override
  public void updateInvoice(Invoice invoice) {
    int id = invoice.getId();
    removeInvoice(id);
    invoiceRepository.save(invoice);
    invoice.setId(id);
  }

  @Override
  public void removeInvoice(int id) {
    invoiceRepository.delete(id);
  }

  @Override
  public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
    List<Invoice> invoiceListInDateRange = new ArrayList<>();
    invoiceRepository.findByDateBetween(fromDate, toDate).forEach(invoiceListInDateRange::add);
    return invoiceListInDateRange;
  }
}
