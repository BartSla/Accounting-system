package processing;

import domain.Invoice;
import org.junit.Test;
import persistence.InMemoryDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceBookTest {

    @Test
    public void shouldAddNewInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());

        //when
        book.addNewInvoice(invoiceProvider.invoice);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), book.getAllInvoices());
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        book.removeInvoice(1);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), book.getAllInvoices());
    }

    @Test
    public void shouldGetInvoiceByIdWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when

        //then
        assertEquals(invoiceProvider.invoice1, book.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when

        //then
        assertEquals(invoiceProvider.getListOf2Invoices(), book.getAllInvoices());
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        invoiceProvider.invoice3.setId(1);
        book.updateInvoice(invoiceProvider.invoice3);

        //then
        assertEquals(invoiceProvider.invoice3, book.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesInDateRangeWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook(new InMemoryDatabase());
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);
        book.addNewInvoice(invoiceProvider.invoice2);
        book.addNewInvoice(invoiceProvider.invoice3);
        book.addNewInvoice(invoiceProvider.invoice4);

        List<Invoice> expected = new ArrayList<>();
        expected.add(invoiceProvider.invoice2);
        expected.add(invoiceProvider.invoice3);
        expected.add(invoiceProvider.invoice4);

        //when

        //then
        assertEquals(expected, book.getAllInvoicesInDateRange(LocalDate.of(2018, 2, 3),
                LocalDate.of(2018, 2 ,9)));
    }
}