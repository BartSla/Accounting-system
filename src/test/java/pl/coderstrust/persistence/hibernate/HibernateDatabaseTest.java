package pl.coderstrust.persistence.hibernate;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderstrust.Application;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;
import pl.coderstrust.persistence.InvoiceProvider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class HibernateDatabaseTest {

  @Autowired
  private Database hibernateDatabase;

  @Autowired
  InvoiceRepository invoiceRepository;

  InvoiceProvider invoiceProvider = new InvoiceProvider();


  @Test
  public void shouldSaveInvoiceInDatabase() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);

    Invoice testInvoice = hibernateDatabase.getInvoiceById(1);

    assertEquals(invoiceProvider.invoice1, testInvoice);
  }

  @Test
  public void shouldGetAllInvoices() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    assertEquals(2, hibernateDatabase.getAllInvoices().size());
  }


  @Test
  public void shouldGetInvoiceById() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);

    Invoice testInvoice = hibernateDatabase.getInvoiceById(1);

    assertEquals(1, testInvoice.getId());
  }

  @Test
  public void shouldUpdateInvoiceInDatabase() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    hibernateDatabase.updateInvoice(invoiceProvider.invoiceToUpdate);

    assertEquals(invoiceProvider.invoiceToUpdate,hibernateDatabase.getInvoiceById(2));
  }

  @Test
  public void shouldRemoveInvoiceFromDatabase() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);
    hibernateDatabase.removeInvoice(2);

    assertEquals(1, hibernateDatabase.getAllInvoices().size());
  }

  @Test
  public void shouldGetOnInvoicesInDataRange() {

    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    assertEquals(invoiceProvider.getListOf1Invoices().size(), hibernateDatabase.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 2, 2)).size());
  }
}