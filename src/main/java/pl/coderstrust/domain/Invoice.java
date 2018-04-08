package pl.coderstrust.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

@ApiModel(value= "Invoice", description="Sample model of invoice")
public class Invoice {

    private Company buyer;
    private Company seller;
    private int id;
    private LocalDate date;
    private List<InvoiceEntry> entryList;

    public Invoice(Company buyer, Company seller, int id, LocalDate date, List<InvoiceEntry> entryList) {
        this.buyer = buyer;
        this.seller = seller;
        this.id = id;
        this.date = date;
        this.entryList = entryList;
    }

    public Invoice(Company buyer, Company seller, int id, LocalDate date) {
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

    @ApiModelProperty(value = "Buyer", required = true)
    public Company getBuyer() {
        return buyer;
    }

    public void setBuyer(Company buyer) {
        this.buyer = buyer;
    }

    @ApiModelProperty(value = "Seller", required = true)
    public Company getSeller() {
        return seller;
    }

    public void setSeller(Company seller) {
        this.seller = seller;
    }

    @ApiModelProperty(value = "ID number", example = "111")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ApiModelProperty(value = "Date", required = true, example = "2019-04-13")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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