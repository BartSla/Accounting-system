package pl.coderstrust.domain;

public class Company {

    private String name;
    private String nip;
    private String streetAndNumber;
    private String city;
    private String postcode;


    public Company(String name, String nip, String streetAndNumber, String city, String postcode) {
        this.name = name;
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
                ", nip='" + nip + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
