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
}