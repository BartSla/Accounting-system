package domain;

public class Company {

  private String name;
  private String nip;
  private String streetAndNumber;
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

  public String streetAndNumber() {
    return streetAndNumber;
  }

  public void streetAndNumber(String streetAndNumber) {
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
