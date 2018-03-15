package processing;

import domain.Invoice;

public interface Visitor {
    //FIXME: this should return double - particular tax value from the proper visitor
    void visit(Invoice invoice);
}
