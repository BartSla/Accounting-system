package persistence;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class InFileDatabaseTest {

    private InvoiceProvider invoiceProvider = new InvoiceProvider();
    private InFileDatabase inFileDatabase = new InFileDatabase();

    @Before
    public void beforeTest(){
        new File("src/test/resources/database.json").delete();
    }

    @Test
    public void saveAndGetInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getListOf1Invoices(), inFileDatabase.getAllInvoices());
    }

    @Test
    public void getInvoiceById() throws Exception {
    inFileDatabase.saveInvoice(invoiceProvider.invoice);
    inFileDatabase.saveInvoice(invoiceProvider.invoice1);
    inFileDatabase.saveInvoice(invoiceProvider.invoice2);
    assertEquals(invoiceProvider.invoice,inFileDatabase.getInvoiceById(0));
    }

    @Test
    public void updateInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.updateInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.invoice1 ,inFileDatabase.getInvoiceById(1));
    }

    @Test
    public void removeInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.removeInvoice(2);
        assertEquals(invoiceProvider.getListOf2Invoices(),inFileDatabase.getAllInvoices());
    }
}