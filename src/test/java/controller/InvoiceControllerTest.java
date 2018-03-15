package controller;

import domain.Invoice;
import org.junit.Test;
import persistence.InMemoryDatabase;
import processing.InvoiceBook;
import persistence.InvoiceProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceControllerTest {

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));
        controller.addInvoice(invoiceProvider.invoice);
        controller.addInvoice(invoiceProvider.invoice1);

        //when
        //FIXME: what is tested in here? when is empty...

        //then
        assertEquals(invoiceProvider.getListOf2Invoices(), controller.getAllInvoices());
    }

    @Test
    public void shouldGetInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));
        controller.addInvoice(invoiceProvider.invoice);
        controller.addInvoice(invoiceProvider.invoice1);

        //when
        //FIXME: what is tested in here? when is empty...

        //then
        assertEquals(invoiceProvider.invoice1, controller.getInvoice(1));
    }

    @Test
    public void updateInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));
        controller.addInvoice(invoiceProvider.invoice);
        controller.addInvoice(invoiceProvider.invoice1);

        //when
        invoiceProvider.invoice3.setId(1);
        controller.updateInvoice(invoiceProvider.invoice3);

        //then
        assertEquals(invoiceProvider.invoice3, controller.getInvoice(1));
    }

    @Test
    public void shouldDeleteInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));
        controller.addInvoice(invoiceProvider.invoice);
        controller.addInvoice(invoiceProvider.invoice1);

        //when
        controller.removeInvoice(1);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), controller.getAllInvoices());
    }

    @Test
    public void shouldAddInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));

        //when
        controller.addInvoice(invoiceProvider.invoice);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), controller.getAllInvoices());
    }

    @Test
    public void shouldGetInvoicesInDataRangeWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        //FIXME: This is unit test! there should not be  `new InvoiceBook` nor `new InMemoryDatabase` in here - all the tests should use mocks! (you test Controller in separation from dependency classes!)
        InvoiceController controller = new InvoiceController(new InvoiceBook(new InMemoryDatabase()));
        controller.addInvoice(invoiceProvider.invoice);
        controller.addInvoice(invoiceProvider.invoice1);
        controller.addInvoice(invoiceProvider.invoice2);
        controller.addInvoice(invoiceProvider.invoice3);
        controller.addInvoice(invoiceProvider.invoice4);

        List<Invoice> expected = new ArrayList<>();
        expected.add(invoiceProvider.invoice2);
        expected.add(invoiceProvider.invoice3);
        expected.add(invoiceProvider.invoice4);

        //when
        //FIXME: what is tested in here? when is empty...

        //then
        assertEquals(expected, controller.getInvoicesInDateRange(LocalDate.of(2018, 2, 3),
                LocalDate.of(2018, 2 ,9)));
    }

}