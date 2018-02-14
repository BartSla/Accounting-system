package processing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryDatabaseTest {

    @Test
//    public void saveInvoice() throws Exception {
//            InvoiceProvider invoiceProvider = new InvoiceProvider();
//                InMemoryDatabase t = new InMemoryDatabase();
//                t.saveInvoice(invoiceProvider.invoice);
//                Field field = InMemoryDatabase.class.getDeclaredField("invoices");
//                field.setAccessible(true);
//                Object value = field.get(t);
//              assertEquals(invoiceProvider.getlistof1invoices() , value);
//              }

    public void saveInvoice() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());

    }
    @Test
    public void removeInvoice() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice1);
        inMemoryDatabase.removeInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());


    }

    @Test
    public void removeInvoiceById() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice1);
        inMemoryDatabase.removeInvoiceById(1);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());

    }

    @Test
    public void getInvoices() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inMemoryDatabase.getInvoices());
    }

    @Test
    public void getInvoiceById() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice);
        inMemoryDatabase.saveInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.invoice1,inMemoryDatabase.getInvoiceById(1));
    }

    @Test
    public void updateInvoice() throws Exception {

    }

}