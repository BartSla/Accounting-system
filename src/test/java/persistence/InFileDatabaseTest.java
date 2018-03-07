package persistence;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class InFileDatabaseTest {

    InvoiceProvider invoiceProvider = new InvoiceProvider();
    InFileDatabase inFileDatabase = new InFileDatabase();
    FileHelper fileHelper = new FileHelper();

    @Test
    public void saveInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inFileDatabase.getInvoices());
    }

    @Test
    public void getInvoices() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getlistof1invoices(), inFileDatabase.getInvoices());
    }

    @Test
    public void getInvoiceById() throws Exception {
    inFileDatabase.saveInvoice(invoiceProvider.invoice);
    inFileDatabase.saveInvoice(invoiceProvider.invoice1);
    inFileDatabase.saveInvoice(invoiceProvider.invoice2);
    assertEquals(invoiceProvider.invoice1,inFileDatabase.getInvoiceById(2));
    }

    @Test
    public void updateInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.updateInvoice(invoiceProvider.invoiceid1);
        assertEquals(invoiceProvider.invoiceid1,inFileDatabase.getInvoiceById(1));
    }

    @Test
    public void removeInvoice() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.removeInvoice(invoiceProvider.invoice2);
        assertEquals(invoiceProvider.getlistof2invoices(),inFileDatabase.getInvoices());
    }
}