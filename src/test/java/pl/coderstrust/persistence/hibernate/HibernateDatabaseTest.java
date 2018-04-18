package pl.coderstrust.persistence.hibernate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderstrust.Application;
import pl.coderstrust.persistence.Database;
import pl.coderstrust.persistence.InvoiceProvider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HibernateDatabaseTest {

  @Autowired
  private Database hibernateDatabase;

  private InvoiceProvider invoiceProvider = new InvoiceProvider();

  @Test
  public void shouldSaveInvoiceInDatabase() {
    assertTrue(hibernateDatabase instanceof HibernateDatabase);
    System.out.println("qq");
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
  }
}