package processing;

import domain.Invoice;

public interface Visitor {
    void visit(Invoice invoice);
}
