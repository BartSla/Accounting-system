package pl.coderstrust.domain;

import java.time.LocalDate;
import java.util.List;

public class Invoice {

    private Company buyer;
    private Company seller;
    private int id;
    private LocalDate date;
    private List<InvoiceEntry> entryList;

    public Invoice(Buyer buyer, Seller seller, int id, LocalDate date, List<InvoiceEntry> entryList) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
        this.entryList = entryList;
    }

    public Invoice(Buyer buyer, Seller seller, int id, LocalDate date) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
    }

    public Invoice() {
    }

    public List<InvoiceEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<InvoiceEntry> entryList) {
        this.entryList = entryList;
    }

    public Company getBuyer() {
        return buyer;
    }

    public void setBuyer(Company buyer) {
        this.buyer = buyer;
    }

    public Company getSeller() {
        return seller;
    }

    public void setSeller(Company seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

<<<<<<< HEAD
    //FIXME: it should return double (or BigDecimal)
    public void accept(Visitor visitor) {
        visitor.visit(this);
=======
    public Invoice() {
    }

    public Invoice(LocalDate date) {
        this.date = date;
    }

    public Invoice(Company buyer, Company seller, int id, LocalDate date) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;

    }

    public Invoice(Company buyer, Company seller, int id, LocalDate date, List<InvoiceEntry> entryList) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
        this.entryList = entryList;
>>>>>>> fb91407be67d0d5ad8e0a08d60c2aa5eec0e4580
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (buyer != null ? !buyer.equals(invoice.buyer) : invoice.buyer != null) return false;
        if (seller != null ? !seller.equals(invoice.seller) : invoice.seller != null) return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        return entryList != null ? entryList.equals(invoice.entryList) : invoice.entryList == null;
    }

    @Override
    public int hashCode() {
        int result = buyer != null ? buyer.hashCode() : 0;
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (entryList != null ? entryList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "buyer=" + buyer +
                ", seller=" + seller +
                ", id=" + id +
                ", date=" + date +
                ", entryList=" + entryList +
                '}';
    }
}