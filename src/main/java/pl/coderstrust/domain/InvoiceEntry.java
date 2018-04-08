package pl.coderstrust.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pl.coderstrust.processing.Vat;

@ApiModel(value= "Items list", description="List of items")
public class InvoiceEntry {

    private String name;
    private Vat vat;
    private Double nettValue;
    private Double grossValue;

    @ApiModelProperty(value = "Item name", required = true, example = "Apple 6" )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "Vat value", required = true, example = "168,11")
    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    @ApiModelProperty(value = "Nett value", required = true, example = "730,89")
    public Double getNettValue() {
        return nettValue;
    }

    public void setNettValue(Double nettValue) {
        this.nettValue = nettValue;
    }

    @ApiModelProperty(value = "Gross value", required = true, example = "899")
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