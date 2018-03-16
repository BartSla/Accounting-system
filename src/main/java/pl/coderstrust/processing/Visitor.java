package pl.coderstrust.processing;

import pl.coderstrust.domain.Invoice;

public interface Visitor {
    void visit(Invoice invoice);
}
