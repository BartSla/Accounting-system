package persistence;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class InFileDatabaseTest {

    private InvoiceProvider invoiceProvider = new InvoiceProvider();
    private InFileDatabase inFileDatabase = new InFileDatabase();

    @Before
    public void beforeTest() {
        new File("src/test/resources/database.json").delete();
    }

    @Test
    public void shouldSaveAndGetInvoiceWorks() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        assertEquals(invoiceProvider.getListOf1Invoices(), inFileDatabase.getAllInvoices());
    }

    @Test
    public void shouldGetInvoiceByIdWorks() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        assertEquals(invoiceProvider.invoice, inFileDatabase.getInvoiceById(0));
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.updateInvoice(invoiceProvider.invoice1);
        assertEquals(invoiceProvider.invoice1, inFileDatabase.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesInDateRangeWorks() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.saveInvoice(invoiceProvider.invoice3);
        inFileDatabase.saveInvoice(invoiceProvider.invoice4);
        assertEquals(invoiceProvider.getListOf3invoices(), inFileDatabase.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 30),
                LocalDate.of(2018, 2, 3)));
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {
        inFileDatabase.saveInvoice(invoiceProvider.invoice);
        inFileDatabase.saveInvoice(invoiceProvider.invoice1);
        inFileDatabase.saveInvoice(invoiceProvider.invoice2);
        inFileDatabase.removeInvoice(2);
        assertEquals(invoiceProvider.getListOf2Invoices(), inFileDatabase.getAllInvoices());

    }
}