package processing;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Invoice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import persistence.Database;

public class InFileDatabase implements Database {

  private List <Invoice>invoices = new ArrayList();
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

// do poprawy
//      List <String> stringInvoices = filehelper.readValueFromJsonString();
//      List <Invoice> invoices = mapper.readValue((JsonParser) stringInvoices, Invoice.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return invoices;
  }
//
//  @Override
//  public Invoice invoice getInvoiceById(int id) {
//    return ;
//
//  }

  @Override
  public void updateInvoice(Invoice invoice) {
  }

  @Override
  public void removeInvoice(Invoice invoice) {
  }

  @Override
  public void removeInvoiceById(int id) {
  }
}
