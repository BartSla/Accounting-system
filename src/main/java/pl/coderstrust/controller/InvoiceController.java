package pl.coderstrust.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import pl.coderstrust.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.coderstrust.processing.EmailSenderImpl;
import pl.coderstrust.processing.InvoiceBook;

import java.time.LocalDate;
import java.util.List;

@RestController
@Api(value = "Invoice Controller API", description = "Invoice Controller API")
public class InvoiceController {

  @Value("${sendTo.email}")
  String emailTo;

  private InvoiceBook invoiceBook;

  @Autowired
  private EmailSenderImpl emailSender;

  @Autowired
  public InvoiceController(InvoiceBook invoiceBook) {
    this.invoiceBook = invoiceBook;
  }

  @ApiOperation(value = "Get all invoices",
      notes = "Return list of all invoices available in database",
      response = Invoice.class,
      responseContainer = "List")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 401, message = "You are not authorised to get all invoices"),
          @ApiResponse(code = 404, message = "Invoices couldn't be found")}
  )
  @RequestMapping(value = "/invoices", method = RequestMethod.GET)
  public List<Invoice> getAllInvoices() {
    return invoiceBook.getAllInvoices();
  }

  @ApiOperation(value = "Gets invoice with specific ID",
      notes = "Return invoice with specific ID available in database")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 401, message = "You are not authorised to get invoice with specific ID"),
          @ApiResponse(code = 404, message = "Invoices with specific couldn't be found")}
  )
  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
  public Invoice getInvoice(@ApiParam
      (value = "Type ID of invoice to get", required = true) @PathVariable("id") int id) {
    return invoiceBook.getInvoiceById(id);
  }

  @ApiOperation("Updates invoice")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 201, message = "Invoice updated successfully"),
          @ApiResponse(code = 401, message = "You are not authorised to add new invoice"),
          @ApiResponse(code = 404, message = "Invoice couldn't be found"),
      }
  )
  @RequestMapping(value = "/invoice", method = RequestMethod.PUT)
  public void updateInvoice(@ApiParam
      (value = "Invoice that needs to be updated", required = true)
  @RequestBody Invoice invoice) {
    invoiceBook.updateInvoice(invoice);
  }

  @ApiOperation("Removes invoice")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 204, message = "Invoice removed successfully"),
          @ApiResponse(code = 401, message = "You are not authorised to remove invoice")}
  )
  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
  public void removeInvoice(@ApiParam
      (value = "Type invoice ID to delete", required = true)
  @PathVariable("id") int id) {
    invoiceBook.removeInvoice(id);
  }

  @ApiOperation("Adds new invoice")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 201, message = "Invoice added successfully"),
          @ApiResponse(code = 401, message = "You are not authorised to add new invoice"),
          @ApiResponse(code = 404, message = "Invoice couldn't be found"),
      }
  )
  @RequestMapping(value = "/invoice", method = RequestMethod.POST)
  public void addInvoice(@ApiParam
      (value = "Invoice that needs to be added", required = true)
  @RequestBody Invoice invoice) {
    invoiceBook.addNewInvoice(invoice);
    emailSender.sendEmail(emailTo,  "Invoice Added",
        invoice.toString() + System.lineSeparator()
            + "was added to database in " + invoice.getDate());
  }

  @ApiOperation(value = "Get in specific date range",
      notes = "Return list of all invoices available in database in specific date range",
      response = Invoice.class,
      responseContainer = "List")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "Successful"),
          @ApiResponse(code = 401, message = "You are not authorised to get invoices in specific date range"),
          @ApiResponse(code = 404, message = "Invoices couldn't be found")}
  )
  @RequestMapping(value = "/invoicesByDate", method = RequestMethod.GET)
  public List<Invoice> getInvoicesInDateRange(
      @ApiParam(value = "Enter date FROM in format YYYY-MM-DD ", required = true)
      @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @ApiParam(value = "Enter date TO in format YYYY-MM-DD", required = true)
      @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
    return invoiceBook.getAllInvoicesInDateRange(from, to);
  }
}