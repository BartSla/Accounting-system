package processing;

public enum Vat {

    TWENTY_SEVEN(27),
    TWENTY_FIVE(25),
    TWENTY_THREE(23),
    TWENTY_TWO(22),
    TWENTY_ONE(21),
    TWENTY(20),
    NIGHTEEN(19),
    FIFTEEN(15),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    FIVE(5),
    THREE(3),
    ZERO(0);

    private final int value;

    Vat(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
