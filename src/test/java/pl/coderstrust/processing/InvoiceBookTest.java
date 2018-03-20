package pl.coderstrust.processing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;
import pl.coderstrust.persistence.InvoiceProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceBookTest {

    @Mock
    private Database database;

    @Test
    public void shouldAddNewInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);

        //when
        invoiceBook.addNewInvoice(invoiceProvider.invoice);

        //then
        verify(database).saveInvoice(invoiceProvider.invoice);
    }

    @Test
    public void shouldRemoveInvoice() throws Exception {
        //given
        InvoiceBook invoiceBook = new InvoiceBook(database);

        //when
        invoiceBook.removeInvoice(1);

        //then
        verify(database).removeInvoice(1);
    }

    @Test
    public void shouldGetInvoiceById() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        when(database.getInvoiceById(1)).thenReturn(invoiceProvider.invoice1);

        //when
        Invoice invoice = invoiceBook.getInvoiceById(1);

        //then
        assertEquals(invoiceProvider.invoice1, invoice);
    }

    @Test
    public void shouldGetAllInvoices() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        when(database.getAllInvoices()).thenReturn(invoices);

        //when
        List<Invoice> result = invoiceBook.getAllInvoices();

        //then
        assertEquals(invoiceProvider.getListOf2Invoices(), result);
    }

    @Test
    public void shouldUpdateInvoice() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);

        //when
        invoiceBook.updateInvoice(invoiceProvider.invoiceToUpdate);

        //then
        verify(database).updateInvoice(invoiceProvider.invoiceToUpdate);
    }

    @Test
    public void shouldGetAllInvoicesInDateRange() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        invoices.add(invoiceProvider.invoice2);
        when(database.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 31), LocalDate.of(2018, 2, 3)))
                .thenReturn(invoices);

        //when
        List<Invoice> result = invoiceBook.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 31), LocalDate.of(2018, 2, 3));

        //then
        assertEquals(invoiceProvider.getListOf3Invoices(), result);
    }
}