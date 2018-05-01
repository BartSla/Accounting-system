package pl.coderstrust.persistence.hibernate;

import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.coderstrust.domain.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

  Iterable<Invoice> findByDateBetween(LocalDate fromDate, LocalDate toDate);
}
