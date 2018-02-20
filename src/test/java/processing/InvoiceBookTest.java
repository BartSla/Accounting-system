package processing;

import domain.Buyer;
import domain.Invoice;
import domain.Seller;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceBookTest {
    @Test
    public void shouldAddNewInvoiceWorks() throws Exception {
        //given
        Invoice invoice = new Invoice();
        Buyer buyer = new Buyer();
        Seller seller = new Seller();

        invoice.setBuyer(buyer);
        invoice.setSeller(seller);
        invoice.setId(1);

        InvoiceBook book = new InvoiceBook();

        //when
        book.addNewInvoice(invoice);

        //then
        assertEquals(book.database.getInvoiceById(0), invoice);
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {
        //given
        Invoice invoice = new Invoice();
        Invoice invoice2 = new Invoice();

        invoice.setId(0);
        invoice2.setId(1);

        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoice);
        book.addNewInvoice(invoice2);

        //when
        book.removeInvoice(invoice);

        //then
        assertEquals(book.database.getInvoiceById(0), invoice2);
    }

    @Test
    public void shouldGetInvoiceByIdWorks() throws Exception {
        //given
        Invoice invoice = new Invoice();
        Invoice invoice2 = new Invoice();

        invoice.setId(0);
        invoice2.setId(1);

        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoice);
        book.addNewInvoice(invoice2);

        //when
        book.getInvoiceById(1);

        //then
        assertEquals(book.database.getInvoiceById(1), invoice2);
    }

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        Invoice invoice = new Invoice();
        Invoice invoice2 = new Invoice();

        invoice.setId(0);
        invoice2.setId(1);

        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoice);
        book.addNewInvoice(invoice2);

        List<Invoice> expected = new ArrayList<>();
        expected.add(invoice);
        expected.add(invoice2);

        //when
        book.getAllInvoices();
        List<Invoice> invoices = book.database.getInvoices();

        //then
        assertEquals(expected, invoices);
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {
        //given
        Invoice invoice = new Invoice();
        Invoice invoice2 = new Invoice();

        invoice.setId(0);

        InvoiceBook book = new InvoiceBook();
        book.addNewInvoice(invoice);

        invoice2.setId(0);

        //when
        book.updateInvoice(invoice2);
        book.database.updateInvoice(invoice2);

        //then
        assertEquals(book.database.getInvoiceById(0), invoice2);
    }

}