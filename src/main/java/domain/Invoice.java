package domain;


import processing.Visitable;
import processing.Visitor;

import java.time.LocalDate;
import java.util.List;

public class Invoice implements Visitable {

    private Buyer buyer;
    private Seller seller;
    private int id;
    private LocalDate date;
    private List<InvoiceEntry> entryList;

    public List<InvoiceEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<InvoiceEntry> entryList) {
        this.entryList = entryList;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
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

    public Invoice(Buyer buyer, Seller seller, int id, LocalDate date) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
    }

    public Invoice(Buyer buyer, Seller seller, int id, LocalDate date, List<InvoiceEntry> entryList) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
        this.entryList = entryList;
    }

    public Invoice() {
    }


    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}