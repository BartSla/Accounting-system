package persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryDatabaseTest {
    InMemoryDatabase inMemoryDatabase;
    InvoiceProvider invoiceProvider;

    @Before
    public void setUp() throws Exception {
        invoiceProvider = new InvoiceProvider();
        inMemoryDatabase = new InMemoryDatabase();
    }

    @Test
    public void saveInvoice() throws Exception {
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());

    }

    @Test
    public void removeInvoice() throws Exception {
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice1);
        inMemoryDatabase.removeInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());


    }

    @Test
    public void getInvoices() throws Exception {
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());
    }

    @Test
    public void getInvoiceById() throws Exception {
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.invoice1, inMemoryDatabase.getInvoiceById(1));
    }

    @Test
    public void updateInvoice() throws Exception {
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.updateInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(),inMemoryDatabase.getInvoices());
    }

}