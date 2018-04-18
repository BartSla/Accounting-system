package pl.coderstrust.persistence.hibernate;

import org.junit.jupiter.api.Test;
import pl.coderstrust.persistence.InvoiceProvider;

class HibernateDatabaseTest {


  private HibernateDatabase hibernateDatabase = new HibernateDatabase();
  private InvoiceProvider invoiceProvider = new InvoiceProvider();



  @Test
  void shouldSaveInvoiceInDatabase() {
    System.out.println("qq");
    hibernateDatabase.saveInvoice(invoiceProvider.invoice1);
  }
}