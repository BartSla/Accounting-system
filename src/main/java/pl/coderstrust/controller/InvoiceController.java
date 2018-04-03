package pl.coderstrust.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import pl.coderstrust.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;
import java.util.List;

@RestController
@Api(value = "Invoice Controller API", description = "Invoice Controller API")
public class InvoiceController {

  private InvoiceBook invoiceBook;

  @Autowired
  public InvoiceController(InvoiceBook invoiceBook) {
    this.invoiceBook = invoiceBook;
  }

  @ApiOperation("Gets all invoices")
  @RequestMapping(value = "/invoices", method = RequestMethod.GET)
  public List<Invoice> getAllInvoices() {
    return invoiceBook.getAllInvoices();
  }

  @ApiOperation("Gets invoice with specific ID")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 401, message = "Authorization needed"),
          @ApiResponse(code = 500, message = "Invoice not found")}
  )
  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
  public Invoice getInvoice(@PathVariable("id") int id) {
    return invoiceBook.getInvoiceById(id);
  }

  @ApiOperation("Updates invoice")
  @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
  public void updateInvoice(@RequestBody Invoice invoice) {
    invoiceBook.updateInvoice(invoice);
  }

  @ApiOperation("Removes invoice")
  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
  public void removeInvoice(@PathVariable("id") int id) {
    invoiceBook.removeInvoice(id);
  }

  @ApiOperation("Adds new invoice")
  @RequestMapping(value = "/invoice", method = RequestMethod.POST)
  public void addInvoice(@RequestBody Invoice invoice) {
    invoiceBook.addNewInvoice(invoice);
  }

  @ApiOperation("Gets invoices in specific data range")
  @RequestMapping(value = "/invoicesByDate", method = RequestMethod.GET)
  public List<Invoice> getInvoicesInDateRange(
      @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
    return invoiceBook.getAllInvoicesInDateRange(from, to);
  }
}