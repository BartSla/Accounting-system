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
    private Vat vat= Vat.TWENTY_THREE;
    private Company buyer = new Company("ABC1", 0, "000", "New1", "Wroclaw", "55-120");
    private Company buyer1 = new Company("ABC2", 1,"111", "New1", "Wroclaw", "55-120");
    private Company buyer2 = new Company("ABC3",2, "222", "New1", "Wroclaw", "55-120");
    private Company buyer3 = new Company("ABC4", 3, "333", "New1", "Wroclaw", "55-120");
    private Company buyer4 = new Company("ABC5", 4, "444", "New1", "Wroclaw", "55-120");
    private Company seller = new Company("QWE1", 5, "aaa", "Old1", "Wroclaw", "55106");
    private Company seller1 = new Company("QWE2", 6, "bbb", "Old1", "Wroclaw", "55106");
    private Company seller2 = new Company("QWE3", 7, "ccc", "Old1", "Wroclaw", "55106");
    private Company seller3 = new Company("QWE4", 8, "ddd", "Old1", "Wroclaw", "55106");
    private Company seller4 = new Company("QWE5", 9,"fff", "Old1", "Wroclaw", "55106");

    public Invoice invoice = new Invoice(buyer, seller, 0, LocalDate.of(2017, 1, 30), getListOfOneInvoiceEntry());
    public Invoice invoice1 = new Invoice(buyer, seller1, 1, LocalDate.of(2018, 2, 1),getListOf2InvoiceEntry());
    public Invoice invoice2 = new Invoice(buyer, seller2, 2, LocalDate.of(2018, 2, 3),getListOf3InvoiceEntry());
    public Invoice invoice3 = new Invoice(buyer3, seller3, 3, LocalDate.of(2018, 2, 5));
    public Invoice invoice4 = new Invoice(buyer4, seller4, 4, LocalDate.of(2018, 2, 9));
    public Invoice invoiceToUpdate = new Invoice(buyer, seller1, 2, LocalDate.of(2111, 2, 1), getListOfOneInvoiceEntry());


    public List<InvoiceEntry> getListOfOneInvoiceEntry(){
        InvoiceEntry invoiceEntry = new InvoiceEntry("ołówek",vat, new BigDecimal("100.00"), new BigDecimal("123.00"));
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        return  invoiceEntries;
    }
    public List<InvoiceEntry> getListOf2InvoiceEntry(){
        InvoiceEntry invoiceEntry = new InvoiceEntry("ołówek",vat, new BigDecimal("100.00"), new BigDecimal("123.00"));
        InvoiceEntry invoiceEntry1 = new InvoiceEntry("pióro",vat, new BigDecimal("200.00"), new BigDecimal("246.00"));
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        invoiceEntries.add(invoiceEntry1);
        return  invoiceEntries;
    }
    public List<InvoiceEntry> getListOf3InvoiceEntry(){
        InvoiceEntry invoiceEntry = new InvoiceEntry("ołówek",vat, new BigDecimal(100.00), new BigDecimal(123));
        InvoiceEntry invoiceEntry1 = new InvoiceEntry("pióro",vat, new BigDecimal(200), new BigDecimal(246));
        InvoiceEntry invoiceEntry2 = new InvoiceEntry("flamaster",vat, new BigDecimal(50), new BigDecimal(61.50));
        List<InvoiceEntry> invoiceEntries = new ArrayList<>();
        invoiceEntries.add(invoiceEntry);
        invoiceEntries.add(invoiceEntry1);
        invoiceEntries.add(invoiceEntry2);
        return  invoiceEntries;
    }

    public List<Invoice> getListOf1Invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice1);
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