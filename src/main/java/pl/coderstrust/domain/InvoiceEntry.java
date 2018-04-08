package pl.coderstrust.domain;

import pl.coderstrust.processing.Vat;

import java.math.BigDecimal;

public class InvoiceEntry {

    private String name;
    private Vat vat;
    private BigDecimal nettValue;
    private BigDecimal grossValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public BigDecimal getNettValue() {
        return nettValue;
    }

    public void setNettValue(BigDecimal nettValue) {
        this.nettValue = nettValue;
    }

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