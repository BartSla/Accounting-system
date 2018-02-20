package processing;

import domain.Buyer;
import domain.Invoice;
import domain.Seller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceProvider {

    private Buyer buyer = new Buyer("ABC1", "896", "Nowa1", "Wroclaw", "55-120");
    private Buyer buyer1 = new Buyer("ABC2", "896", "Nowa1", "Wroclaw", "55-120");
    private Buyer buyer2 = new Buyer("ABC3", "896", "Nowa1", "Wroclaw", "55-120");
    private Buyer buyer3 = new Buyer("ABC4", "896", "Nowa1", "Wroclaw", "55-120");
    private Buyer buyer4 = new Buyer("ABC5", "896", "Nowa1", "Wroclaw", "55-120");
    private Seller seller = new Seller("QWE1", "987", "Stara1", "Wroclaw", "55106");
    private Seller seller1 = new Seller("QWE2", "987", "Stara1", "Wroclaw", "55106");
    private Seller seller2 = new Seller("QWE3", "987", "Stara1", "Wroclaw", "55106");
    private Seller seller3 = new Seller("QWE4", "987", "Stara1", "Wroclaw", "55106");
    private Seller seller4 = new Seller("QWE5", "987", "Stara1", "Wroclaw", "55106");

    Invoice invoice = new Invoice(buyer, seller, 0, LocalDate.of(2018, 1, 30));
    Invoice invoice1 = new Invoice(buyer1, seller1, 1, LocalDate.of(2018, 2, 1));
    Invoice invoice2 = new Invoice(buyer2, seller2, 2, LocalDate.of(2018, 2, 3));
    Invoice invoice3 = new Invoice(buyer3, seller3, 3, LocalDate.of(2018, 2, 5));
    Invoice invoice4 = new Invoice(buyer4, seller4, 4, LocalDate.of(2018, 2, 9));

    public List<Invoice> getlistof1invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        return invoices;
    }

    public List<Invoice> getlistof2invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        return invoices;
    }

    public List<Invoice> getlistof3invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        return invoices;
    }

    public List<Invoice> getlistof4invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        return invoices;
    }

    public List<Invoice> getlistof5invoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        invoices.add(invoice4);
        return invoices;
    }
}