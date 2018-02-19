package persistence;

import domain.Buyer;
import domain.Invoice;
import domain.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceProvider {
    Buyer buyer = new Buyer("ABC1", "896", "Nowa1","Wroclaw","55-120");
    Buyer buyer1 = new Buyer("ABC2", "896", "Nowa1","Wroclaw","55-120");
    Buyer buyer2 = new Buyer("ABC3", "896", "Nowa1","Wroclaw","55-120");
    Buyer buyer3 = new Buyer("ABC4", "896", "Nowa1","Wroclaw","55-120");
    Buyer buyer4 = new Buyer("ABC5", "896", "Nowa1","Wroclaw","55-120");
    Seller seller = new Seller("QWE1", "987", "Stara1", "Wroclaw","55106");
    Seller seller1 = new Seller("QWE2", "987", "Stara1", "Wroclaw","55106");
    Seller seller2= new Seller("QWE3", "987", "Stara1", "Wroclaw","55106");
    Seller seller3= new Seller("QWE4", "987", "Stara1", "Wroclaw","55106");
    Seller seller4= new Seller("QWE5", "987", "Stara1", "Wroclaw","55106");

    Invoice invoice = new Invoice(buyer, seller, 1, LocalDate.now());
    Invoice invoice1 = new Invoice(buyer1, seller1, 2, LocalDate.now());
    Invoice invoice2 = new Invoice(buyer2, seller2, 3, LocalDate.now());
    Invoice invoice3 = new Invoice(buyer3, seller3, 4, LocalDate.now());
    Invoice invoice4 = new Invoice(buyer4, seller4, 5, LocalDate.now());
    Invoice invoiceid1 = new Invoice(buyer,seller1,1,LocalDate.now());
    public List<Invoice> getlistof1invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        return invoices;
    };
    public List<Invoice> getlistof2invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        return invoices;
    };
    public List<Invoice> getlistof3invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        return invoices;
    };
    public List<Invoice> getlistof4invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        return invoices;
    };
    public List<Invoice> getlistof5invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        invoices.add(invoice4);
        return invoices;
    };


}
