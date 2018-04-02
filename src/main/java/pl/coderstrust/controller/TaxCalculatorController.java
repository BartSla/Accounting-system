package pl.coderstrust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.coderstrust.processing.InvoiceBook;
import pl.coderstrust.processing.TaxCalculatorService;

import java.math.BigDecimal;

@RestController
public class TaxCalculatorController {
    private TaxCalculatorService taxCalculatorService;
    private InvoiceBook invoiceBook;

    @Autowired
    public TaxCalculatorController(TaxCalculatorService taxCalculatorService, InvoiceBook invoiceBook) {
        this.taxCalculatorService = taxCalculatorService;
        this.invoiceBook = invoiceBook;
    }

    @RequestMapping(value = "/invoices/outcomeVat", method = RequestMethod.GET)
    public BigDecimal getOutcomeVat() {
        return taxCalculatorService.getOutcomeVat(invoiceBook.getAllInvoices());
    }

    @RequestMapping(value = "/invoices/outcome", method = RequestMethod.GET)
    public BigDecimal getOutcome() {
        return taxCalculatorService.getOutcome(invoiceBook.getAllInvoices());
    }

    @RequestMapping(value = "/invoices/incomeVat", method = RequestMethod.GET)
    public BigDecimal getIncomeVat() {
        return taxCalculatorService.getIncomeVat(invoiceBook.getAllInvoices());
    }

    @RequestMapping(value = "/invoices/income", method = RequestMethod.GET)
    public BigDecimal getIncome() {
        return taxCalculatorService.getIncome(invoiceBook.getAllInvoices());
    }

}

