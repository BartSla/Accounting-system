package pl.coderstrust.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.InvoiceProvider;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceControllerTest {

    @Mock
    private InvoiceBook invoiceBook;

    @Test
    public void shouldGetAllInvoices() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        when(invoiceBook.getAllInvoices()).thenReturn(invoices);

        //when
        List<Invoice> result = controller.getAllInvoices();

        //then
        assertEquals(invoiceProvider.getListOf2Invoices(), result);
    }

    @Test
    public void shouldGetInvoiceById() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);
        when(invoiceBook.getInvoiceById(0)).thenReturn(invoiceProvider.invoice);

        //when
        Invoice invoice = controller.getInvoice(0);

        //then
        assertEquals(invoiceProvider.invoice, invoice);
    }

    @Test
    public void shouldUpdateInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.updateInvoice(invoiceProvider.invoiceToUpdate);

        //then
        verify(invoiceBook).updateInvoice(invoiceProvider.invoiceToUpdate);
    }

    @Test
    public void shouldDeleteInvoice() throws Exception {
        //given
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.removeInvoice(0);

        //then
        verify(invoiceBook).removeInvoice(0);
    }

    @Test
    public void shouldAddInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.addInvoice(invoiceProvider.invoice);

        //then
        verify(invoiceBook).addNewInvoice(invoiceProvider.invoice);
    }

    @Test
    public void shouldGetInvoicesInDataRange() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);
        LocalDate from = LocalDate.of(2018, 1, 31);
        LocalDate to = LocalDate.of(2018, 2, 3);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        invoices.add(invoiceProvider.invoice2);
        when(invoiceBook.getAllInvoicesInDateRange(from, to)).thenReturn(invoices);

        //when
        List<Invoice> result = controller.getInvoicesInDateRange(from,to);

        //then
        assertEquals(invoiceProvider.getListOf3Invoices(), result);
    }
}