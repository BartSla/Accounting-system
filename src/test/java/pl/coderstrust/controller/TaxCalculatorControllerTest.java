package pl.coderstrust.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.persistence.InvoiceProvider;
import pl.coderstrust.processing.InvoiceBook;
import pl.coderstrust.processing.TaxCalculatorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorControllerTest {
    @Mock
    private InvoiceBook invoiceBook;

    @Test
    public void shouldGetOutcomeVat() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        List<Invoice> testListOfInvoices = new ArrayList<>();
        testListOfInvoices.add(invoiceProvider.invoice);
        testListOfInvoices.add(invoiceProvider.invoice1);
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());

        assertEquals(taxCalculatorService.getOutcomeVat(testListOfInvoices),taxCalculatorController.getOutcomeVat());


    }

    @Test
    public void shouldGetOutcome() throws Exception {
    }

    @Test
    public void shouldGetIncomeVat() throws Exception {
    }

    @Test
    public void shouldGetIncome() throws Exception {
    }

}