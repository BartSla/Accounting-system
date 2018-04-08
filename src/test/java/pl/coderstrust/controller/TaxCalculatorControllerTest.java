package pl.coderstrust.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderstrust.persistence.InvoiceProvider;
import pl.coderstrust.processing.InvoiceBook;
import pl.coderstrust.processing.TaxCalculatorService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorControllerTest {
    @Mock
    private InvoiceBook invoiceBook;
    @Mock
    private  TaxCalculatorService taxCalculatorService;

    @Test
    public void shouldGetOutcomeVat() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());
        when(taxCalculatorService.getOutcomeVat(invoiceBook.getAllInvoices())).thenReturn(new BigDecimal(69));

        //when
        BigDecimal result = taxCalculatorController.getOutcomeVat();

        //then
        assertEquals(new BigDecimal(69),result);
        verify(taxCalculatorService).getOutcomeVat(invoiceProvider.getListOf2Invoices());
    }

    @Test
    public void shouldGetOutcome() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());
        when(taxCalculatorService.getOutcome(invoiceBook.getAllInvoices())).thenReturn(new BigDecimal(300));

        //when
        BigDecimal result = taxCalculatorController.getOutcome();

        //then
        assertEquals(new BigDecimal(300),result);
        verify(taxCalculatorService).getOutcome(invoiceProvider.getListOf2Invoices());
    }

    @Test
    public void shouldGetIncomeVat() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());
        when(taxCalculatorService.getIncomeVat(invoiceBook.getAllInvoices())).thenReturn(new BigDecimal(23));

        //when
        BigDecimal result = taxCalculatorController.getIncomeVat();

        //then
        assertEquals(new BigDecimal(23),result);
        verify(taxCalculatorService).getIncomeVat(invoiceProvider.getListOf2Invoices());
    }

    @Test
    public void shouldGetIncome() throws Exception {
        //given
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());
        when(taxCalculatorService.getIncome(invoiceBook.getAllInvoices())).thenReturn(new BigDecimal(100));

        //when
        BigDecimal result = taxCalculatorController.getIncome();

        //then
        assertEquals(new BigDecimal(100),result);
        verify(taxCalculatorService).getIncome(invoiceProvider.getListOf2Invoices());
    }

}