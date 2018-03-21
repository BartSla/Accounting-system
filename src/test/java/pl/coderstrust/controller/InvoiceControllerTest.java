package pl.coderstrust.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.persistence.InvoiceProvider;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceControllerTest {

    @Mock
    private InvoiceBook invoiceBook;

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.getAllInvoices();

        //then
        verify(invoiceBook).getAllInvoices();
    }

    @Test
    public void shouldGetInvoiceWorks() throws Exception {
        //given
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.getInvoice(0);

        //then
        verify(invoiceBook).getInvoiceById(0);
    }

    @Test
    public void updateInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.updateInvoice(invoiceProvider.invoiceToUpdate);

        //then
        verify(invoiceBook).updateInvoice(invoiceProvider.invoiceToUpdate);
    }

    @Test
    public void shouldDeleteInvoiceWorks() throws Exception {
        //given
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.removeInvoice(0);

        //then
        verify(invoiceBook).removeInvoice(0);
    }

    @Test
    public void shouldAddInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceController controller = new InvoiceController(invoiceBook);

        //when
        controller.addInvoice(invoiceProvider.invoice);

        //then
        verify(invoiceBook).addNewInvoice(invoiceProvider.invoice);
    }

    @Test
    public void shouldGetInvoicesInDataRangeWorks() throws Exception {
        //given
        InvoiceController controller = new InvoiceController(invoiceBook);
        LocalDate from = LocalDate.of(2018, 2, 3);
        LocalDate to = LocalDate.of(2018, 2 ,9);

        //when
        controller.getInvoicesInDateRange(from,to);

        //then
        verify(invoiceBook).getAllInvoicesInDateRange(from, to);
    }
}