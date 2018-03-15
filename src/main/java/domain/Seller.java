package domain;

public class Seller extends Company {
    public Seller(String name, String nip, String streetAndNumber, String city, String postcode) {
        super(name, nip, streetAndNumber, city, postcode);
    }

    //TODO: Is it used by anybody? If no, please remove it.
    public Seller() {
    }
}