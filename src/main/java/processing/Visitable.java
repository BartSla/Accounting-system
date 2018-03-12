package processing;

public interface Visitable {
    void accept(Visitor visitor);
}
