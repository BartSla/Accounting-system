package processing;

import domain.Invoice;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceBookTest {
    @Test
    public void shouldAddNewInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();

        //when
        book.addNewInvoice(invoiceProvider.invoice);

        //then
        assertEquals(invoiceProvider.getlistof1invoices(), book.database.getInvoices());
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        book.removeInvoice(invoiceProvider.invoice1);

        //then
        assertEquals(invoiceProvider.getlistof1invoices(), book.database.getInvoices());
    }

    @Test
    public void shouldGetInvoiceByIdWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        book.getInvoiceById(1);

        //then
        assertEquals(invoiceProvider.invoice1, book.database.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        book.getAllInvoices();

        //then
        assertEquals(invoiceProvider.getlistof2invoices(), book.database.getInvoices());
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoiceProvider.invoice);
        book.addNewInvoice(invoiceProvider.invoice1);

        //when
        invoiceProvider.invoice3.setId(1);
        book.updateInvoice(invoiceProvider.invoice3);

        //then
        assertEquals(invoiceProvider.invoice3, book.database.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesInDateRangeWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook book = new InvoiceBook();
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
        book.getAllInvoicesInDateRange(LocalDate.of(2018, 2, 3),
                LocalDate.of(2018, 2 ,9));

        //then
        assertEquals(expected, book.database.getAllInvoicesInDateRange(LocalDate.of(2018, 2, 3),
                LocalDate.of(2018, 2 ,9)));
    }
}