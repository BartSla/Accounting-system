package pl.coderstrust.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.coderstrust.domain.Invoice;

import java.time.LocalDate;
import java.util.List;

public interface InMongoRepository extends MongoRepository<Invoice,String> {
    List<Invoice> findByDateBetween(LocalDate fromDate, LocalDate toDate);
    Invoice findById(int id);
    void deleteById(int id);


}
