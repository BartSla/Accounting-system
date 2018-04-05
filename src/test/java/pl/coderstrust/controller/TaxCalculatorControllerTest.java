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
        when(invoiceBook.getAllInvoices()).thenReturn(invoiceProvider.getListOf2Invoices());
        TaxCalculatorController taxCalculatorController = new TaxCalculatorController(taxCalculatorService, invoiceBook);
        
        //when
        BigDecimal result = taxCalculatorController.getOutcomeVat();
        //then
        assertEquals(new BigDecimal(92),result);
        verify(taxCalculatorService).getOutcomeVat(invoiceProvider.getListOf2Invoices());
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