package pl.coderstrust.processing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.Database;
import pl.coderstrust.persistence.InvoiceProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceBookTest {

    @Mock
    private Database database;

    @Test
    public void shouldAddNewInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();

        //when
        Mockito.doNothing().when(database).saveInvoice(invoiceProvider.invoice);
        invoiceBook.addNewInvoice(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), invoices);
    }

    @Test
    public void shouldRemoveInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);

        //when
        Mockito.doNothing().when(database).removeInvoice(1);
        invoiceBook.removeInvoice(1);
        invoices.remove(1);

        //then
        assertEquals(invoiceProvider.getListOf1Invoices(), invoices);
    }

    @Test
    public void shouldGetInvoiceByIdWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);

        //when
        when(database.getInvoiceById(1)).thenReturn(invoiceProvider.invoice1);

        //then
        assertEquals(invoiceProvider.invoice1, invoiceBook.getInvoiceById(1));
    }

    @Test
    public void shouldGetAllInvoicesWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);

        //when
        when(database.getAllInvoices()).thenReturn(invoices);

        //then
        assertEquals(invoiceProvider.getListOf2Invoices(), invoiceBook.getAllInvoices());
    }

    @Test
    public void shouldUpdateInvoiceWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        invoices.add(invoiceProvider.invoice2);

        //when
        Mockito.doNothing().when(database).updateInvoice(invoiceProvider.invoice3);
        invoiceProvider.invoice3.setId(1);
        invoiceBook.updateInvoice(invoiceProvider.invoice3);
        invoices.remove(invoiceProvider.invoice1);
        invoices.add(1, invoiceProvider.invoice3);

        //then
        assertEquals(invoiceProvider.invoice3, invoices.get(1));
    }

    @Test
    public void shouldGetAllInvoicesInDateRangeWorks() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        InvoiceBook invoiceBook = new InvoiceBook(database);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceProvider.invoice);
        invoices.add(invoiceProvider.invoice1);
        invoices.add(invoiceProvider.invoice2);

        //when
        when(database.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 31), LocalDate.of(2018, 2, 3)))
                .thenReturn(invoices);

        //then
        assertEquals(invoiceProvider.getListOf3Invoices(), invoiceBook.getAllInvoicesInDateRange(LocalDate.of(2018, 1, 31),
                LocalDate.of(2018, 2, 3)));
    }
}