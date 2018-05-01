package pl.coderstrust.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pl.coderstrust.processing.Vat;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@ApiModel(value= "Items list", description="List of items")
public class InvoiceEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    private Vat vat;
    private BigDecimal nettValue;
    private BigDecimal grossValue;

    @ApiModelProperty(value = "Item name", required = true, example = "Apple 6" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "Vat value", required = true, example = "EIGHT")
    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    @ApiModelProperty(value = "Nett value", required = true, example = "730.89")
    public BigDecimal getNettValue() {
        return nettValue;
    }

    public void setNettValue(BigDecimal nettValue) {
        this.nettValue = nettValue;
    }

    @ApiModelProperty(value = "Gross value", required = true, example = "899.67")
    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public InvoiceEntry(String name, Vat vat, BigDecimal nettValue, BigDecimal grossValue) {
        this.name = name;
        this.vat = vat;
        this.nettValue = nettValue;
        this.grossValue = grossValue;
    }

    public InvoiceEntry() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceEntry that = (InvoiceEntry) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (vat != that.vat) return false;
        if (nettValue != null ? !nettValue.equals(that.nettValue) : that.nettValue != null) return false;
        return grossValue != null ? grossValue.equals(that.grossValue) : that.grossValue == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (nettValue != null ? nettValue.hashCode() : 0);
        result = 31 * result + (grossValue != null ? grossValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvoiceEntry{" +
                "name='" + name + '\'' +
                ", vat=" + vat +
                ", nettValue=" + nettValue +
                ", grossValue=" + grossValue +
                '}';
    }
}