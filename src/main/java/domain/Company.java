package domain;

public class Company {
    private String name;
    private String nip;
    private String street_and_number;
    private String city;
    private String postcode;

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

    public String getStreet_and_number() {
        return street_and_number;
    }

    public void setStreet_and_number(String street_and_number) {
        this.street_and_number = street_and_number;
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
