package pl.coderstrust.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import pl.coderstrust.domain.Invoice;

import java.time.LocalDate;
import java.util.List;

@Repository
@ConditionalOnProperty(name = "pl.coderstrust.database", havingValue = "inMongo")

public class InMongoDatabase implements Database {

    @Autowired
    InMongoRepository repository;

    @Override
    public void saveInvoice(Invoice invoice) {
        repository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return repository.findById(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        repository.delete(invoice.getIdMongo());
        repository.save(invoice);
    }

    @Override
    public void removeInvoice(int id) {
      repository.deleteById(id);
    }

    @Override
    public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
        return repository.findByDateBetween(fromDate,toDate);
    }
}
