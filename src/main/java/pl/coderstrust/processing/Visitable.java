package pl.coderstrust.processing;

public interface Visitable {
    void accept(Visitor visitor);
}
