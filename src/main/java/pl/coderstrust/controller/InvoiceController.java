package pl.coderstrust.controller;

import pl.coderstrust.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;
import java.util.List;

@RestController
public class InvoiceController {

    private InvoiceBook invoiceBook;

    @Autowired
    public InvoiceController(InvoiceBook invoiceBook) {
        this.invoiceBook = invoiceBook;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices() {
        return invoiceBook.getAllInvoices();
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable("id") int id) {
        return invoiceBook.getInvoiceById(id);
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
    public void updateInvoice(@RequestBody Invoice invoice) {
        invoiceBook.updateInvoice(invoice);
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public void removeInvoice(@PathVariable("id") int id) {
        invoiceBook.removeInvoice(id);
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceBook.addNewInvoice(invoice);
    }

    @RequestMapping(value = "/invoicesByDate", method = RequestMethod.GET)
    public List<Invoice> getInvoicesInDateRange(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return invoiceBook.getAllInvoicesInDateRange(from, to);
    }
}