package pl.coderstrust.domain;

import pl.coderstrust.processing.Vat;

public class InvoiceEntry {

    private String name;
    private Vat vat;
    private Double nettValue;
    private Double grossValue;

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

    public Double getNettValue() {
        return nettValue;
    }

    public void setNettValue(Double nettValue) {
        this.nettValue = nettValue;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    //TODO: Is it used by anybody? If no, please remove it.
    public InvoiceEntry(String name, Vat vat, Double nettValue, Double grossValue) {
        this.name = name;
        this.vat = vat;
        this.nettValue = nettValue;
        this.grossValue = grossValue;
    }

    //TODO: Is it used by anybody? If no, please remove it.
    public InvoiceEntry() {
    }
}