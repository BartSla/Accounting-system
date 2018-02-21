package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InFileDatabase implements Database {

  private List<Invoice> invoices = new ArrayList();
  private FileHelper filehelper = new FileHelper();
  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public void saveInvoice(Invoice invoice) {
    if (invoice != null) {
      try {
        String jsonInString = mapper.writeValueAsString(invoice);
        filehelper.writeValueAsStringInFile(jsonInString);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public List<Invoice> getInvoices() {
    try {
      List<String> stringInvoices = filehelper.readValueFromJsonString();
      for (String item : stringInvoices) {
        invoices.add(mapper.readValue(item, Invoice.class));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return invoices;
  }

  @Override
  public Invoice getInvoiceById(int id) {
    Invoice invoiceById = new Invoice();
    for (Invoice invoice : getInvoices()) {
      if (invoice.getId() == id) {
        invoiceById = getInvoices().get(id);
      }
    }
    return invoiceById;
  }

  @Override
  public void updateInvoice(Invoice invoice) {
    getInvoices();
    for (Invoice invoiceById : getInvoices()) {
      if (invoiceById.getId() == invoice.getId()) {
        getInvoices().remove(invoiceById);
        getInvoices().add(invoice);
        filehelper.deleteFile();
      }
      saveInvoice(invoiceById);
    }
  }
  @Override
  public void removeInvoice(Invoice invoice) {

    for (Invoice invoiceForLoop : getInvoices()) {
      if (invoiceForLoop.equals(invoice)) {
        getInvoices().remove(invoice);
      }
    }
  }

  @Override
  public List<Invoice> getAllInvoicesInDateRange(LocalDate fromDate, LocalDate toDate) {
    return null;
  }
}

