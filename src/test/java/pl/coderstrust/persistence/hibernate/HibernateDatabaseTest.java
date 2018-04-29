package pl.coderstrust.persistence.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
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


  @Test
  public void shouldSaveInvoiceInDatabase() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();
    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    Invoice testInvoice = hibernateDatabase.getInvoiceById(1);
//then
    assertEquals(invoiceProvider.invoice1, testInvoice);
  }

  @Test
  public void shouldGetAllInvoices() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();

    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    //then
    assertEquals(invoiceProvider.invoice1, hibernateDatabase.getInvoiceById(1));
  }


  @Test
  public void shouldGetInvoiceById() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();

    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    Invoice testInvoice = hibernateDatabase.getInvoiceById(1);

    //then
    assertEquals(1, testInvoice.getId());
  }

  @Test
  public void shouldUpdateInvoiceInDatabase() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();

    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);
    hibernateDatabase.updateInvoice(invoiceProvider.invoiceToUpdate);

    //then
    assertEquals(invoiceProvider.invoiceToUpdate, hibernateDatabase.getInvoiceById(2));
  }

  @Test
  public void shouldRemoveInvoiceFromDatabase() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();

    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);
    hibernateDatabase.removeInvoice(2);

    //then
    assertNull(hibernateDatabase.getInvoiceById(2));
  }

  @Test
  public void shouldGetOnInvoicesInDataRange() {
    //given
    InvoiceProvider invoiceProvider = new InvoiceProvider();

    //when
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
    hibernateDatabase.saveInvoice(invoiceProvider.invoice2);

    //then
    assertEquals(invoiceProvider.getListOf1Invoices().size(), hibernateDatabase
        .getAllInvoicesInDateRange(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 2, 2)).size());
  }
}