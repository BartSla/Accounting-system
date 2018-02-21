package persistence;

<<<<<<< HEAD
import domain.Invoice;

=======
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Invoice;
import java.io.IOException;
import java.util.ArrayList;
>>>>>>> development
import java.util.List;

public class InFileDatabase implements Database {

<<<<<<< HEAD
  @Override
  public void saveInvoice(Invoice invoice) {
  }

  @Override
  public List<Invoice> getInvoices() {return null;
  }

  @Override
  public Invoice getInvoiceById(int id) {
    return null;
  }

  @Override
  public void updateInvoice(Invoice invoice) {
=======
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
  //do poprawy

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
  //do poprawy

  @Override
  public void updateInvoice(Invoice invoice) {
    getInvoices();
>>>>>>> development
  }

  @Override
  public void removeInvoice(Invoice invoice) {
<<<<<<< HEAD
  }

  @Override
  public void removeInvoiceById(int id) {
  }
}
=======

    for (Invoice invoiceForLoop : getInvoices()) {
      if (invoiceForLoop.equals(invoice)) {
        getInvoices().remove(invoice);
      }
    }
  }
}


>>>>>>> development
