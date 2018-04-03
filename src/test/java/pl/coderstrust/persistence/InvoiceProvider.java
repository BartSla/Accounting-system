package pl.coderstrust.persistence;

import pl.coderstrust.domain.Company;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.domain.InvoiceEntry;
import pl.coderstrust.processing.Vat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceProvider {
    private Vat vat= Vat.valueOf("twenty-three");
    private Company buyer = new Company("ABC1", "896", "New1", "Wroclaw", "55-120");
    private Company buyer1 = new Company("ABC2", "896", "New1", "Wroclaw", "55-120");
    private Company buyer2 = new Company("ABC3", "896", "New1", "Wroclaw", "55-120");
    private Company buyer3 = new Company("ABC4", "896", "New1", "Wroclaw", "55-120");
    private Company buyer4 = new Company("ABC5", "896", "New1", "Wroclaw", "55-120");
    private Company seller = new Company("QWE1", "987", "Old1", "Wroclaw", "55106");
    private Company seller1 = new Company("QWE2", "987", "Old1", "Wroclaw", "55106");
    private Company seller2 = new Company("QWE3", "987", "Old1", "Wroclaw", "55106");
    private Company seller3 = new Company("QWE4", "987", "Old1", "Wroclaw", "55106");
    private Company seller4 = new Company("QWE5", "987", "Old1", "Wroclaw", "55106");

    public Invoice invoice = new Invoice(seller, buyer, 0, LocalDate.of(2018, 1, 30), getListOfOneInvoiceEntry());
    public Invoice invoice1 = new Invoice(buyer, seller1, 1, LocalDate.of(2018, 2, 1),getListOf2InvoiceEntry());
    public Invoice invoice2 = new Invoice(buyer, seller2, 2, LocalDate.of(2018, 2, 3),getListOf3InvoiceEntry());
    public Invoice invoice3 = new Invoice(buyer3, seller3, 3, LocalDate.of(2018, 2, 5));
    public Invoice invoice4 = new Invoice(buyer4, seller4, 4, LocalDate.of(2018, 2, 9));
    public Invoice invoiceToUpdate = new Invoice(buyer1, seller1, 0, LocalDate.of(2018, 2, 1));

    private InvoiceEntry invoiceEntry = new InvoiceEntry("ołówek",vat, new BigDecimal(100), new BigDecimal(123));
    private InvoiceEntry invoiceEntry1 = new InvoiceEntry("pióro",vat, new BigDecimal(200), new BigDecimal(246));
    private InvoiceEntry invoiceEntry2 = new InvoiceEntry("flamaster",vat, new BigDecimal(50), new BigDecimal(61.50));
    public List<InvoiceEntry> getListOfOneInvoiceEntry(){
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        return  invoiceEntries;
    }
    public List<InvoiceEntry> getListOf2InvoiceEntry(){
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        invoiceEntries.add(invoiceEntry1);
        return  invoiceEntries;
    }
    public List<InvoiceEntry> getListOf3InvoiceEntry(){
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        invoiceEntries.add(invoiceEntry1);
        invoiceEntries.add(invoiceEntry2);
        return  invoiceEntries;
    }

    public List<Invoice> getListOf1Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        return invoices;
    }

    public List<Invoice> getListOf2Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        return invoices;
    }

    public List<Invoice> getListOf3Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        return invoices;
    }

    public List<Invoice> getListOf4Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        return invoices;
    }

    public List<Invoice> getListOf5Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        invoices.add(invoice4);
        return invoices;
    }
}