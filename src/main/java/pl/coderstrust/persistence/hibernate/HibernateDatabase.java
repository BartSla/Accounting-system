package pl.coderstrust.persistence.hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;

@Repository
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "hibernate")
public class HibernateDatabase implements Database {

  @Autowired
  private InvoiceRepository invoiceRepository;

  @Override
  public void saveInvoice(Invoice invoice) {
      invoiceRepository.save(invoice);
  }

  @Override
  public List<Invoice> getAllInvoices() {
    return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Invoice getInvoiceById(int id) {
    return invoiceRepository.findOne(id);
  }

  @Override
  public void updateInvoice(Invoice invoice) {
    invoiceRepository.save(invoice);
  }

  @Override
  public void removeInvoice(int id) {
    invoiceRepository.delete(id);
  }

  @Override
  public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {

    return StreamSupport
        .stream(invoiceRepository.findByDateBetween(fromDate, toDate)
            .spliterator(), false)
        .collect(Collectors.toList());
  }
}
