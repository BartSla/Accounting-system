package processing;

public enum Vat {
  TWENTY_THREE(23),
  EIGHT(8),
  FIVE(5),
  ZERO(0);

  //FIXME: I do not get it - what is this value field?
  private final int value;

  Vat(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}