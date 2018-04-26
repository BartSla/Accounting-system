package pl.coderstrust.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
@ApiModel(value= "Company", description="Company data")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String nip;
    private String streetAndNumber;
    private String city;
    private String postcode;


    public Company(  String name, int id, String nip, String streetAndNumber, String city, String postcode) {
        this.name = name;
        this.id = id;
        this.nip = nip;
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.postcode = postcode;
    }

    public Company() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (nip != null ? !nip.equals(company.nip) : company.nip != null) return false;
        if (streetAndNumber != null ? !streetAndNumber.equals(company.streetAndNumber) : company.streetAndNumber != null)
            return false;
        if (city != null ? !city.equals(company.city) : company.city != null) return false;
        return postcode != null ? postcode.equals(company.postcode) : company.postcode == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
        result = 31 * result + (streetAndNumber != null ? streetAndNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", nip='" + nip + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    @ApiModelProperty(value = "Company name", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty(value = "NIP", required = true, example = "6521585544")
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @ApiModelProperty(value = "Street and street number", required = true, example = "Nowa 7")
    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    @ApiModelProperty(value = "City", required = true, example = "Katowice")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ApiModelProperty(value = "Postcode", required = true, example = "40-100")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @ApiModelProperty(value = "Company ID", required = true, example = "22")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
