package pl.coderstrust.processing;

import org.junit.Assert;
import org.junit.Test;
import pl.coderstrust.persistence.InvoiceProvider;

import java.math.BigDecimal;

public class TaxCalculatorServiceTest {
    @Test
    public void getOutcomeVat() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        Assert.assertEquals(new BigDecimal(69), taxCalculatorService.getOutcomeVat(invoiceProvider.getListOf2Invoices()));

    }

    @Test
    public void getIncomeVat() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        Assert.assertEquals(new BigDecimal(23), taxCalculatorService.getIncomeVat(invoiceProvider.getListOf2Invoices()));
    }

    @Test
    public void getIncome() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        Assert.assertEquals(new BigDecimal(100), taxCalculatorService.getIncome(invoiceProvider.getListOf2Invoices()));
    }

    @Test
    public void getOutcome() throws Exception {
        InvoiceProvider invoiceProvider = new InvoiceProvider();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        Assert.assertEquals(new BigDecimal(300), taxCalculatorService.getOutcome(invoiceProvider.getListOf2Invoices()));
    }

}