package processing;

public interface Visitable {
    //FIXME: should return double (or BigDecimal) - particual tax value from the given visitor
    void accept(Visitor visitor);
}
