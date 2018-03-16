package pl.coderstrust.processing;

import pl.coderstrust.domain.Buyer;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.domain.InvoiceEntry;
import pl.coderstrust.domain.Seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorService implements Visitor {
    private BigDecimal incomeVat = new BigDecimal(0);
    private BigDecimal outcomeVat = new BigDecimal(0);
    private BigDecimal income = new BigDecimal(0);
    private BigDecimal costs = new BigDecimal(0);

    private Buyer myCompanyB = new Buyer("ABC", "8909870908", "Nowa15", "Wroclaw", "54-317");
    private Seller myCompanyS = new Seller("ABC", "8909870908", "Nowa15", "Wroclaw", "54-317");


    public void visit(Invoice invoice) {
        if (invoice.getBuyer() == myCompanyB) {
            for (int i = 0; i < invoice.getEntryList().size(); i++) {
                InvoiceEntry temp = invoice.getEntryList().get(i);
                costs = costs.add(new BigDecimal(temp.getNettValue()));
                outcomeVat = outcomeVat.add(new BigDecimal(temp.getGrossValue() - temp.getNettValue()));
            }
        } else if (invoice.getSeller() == myCompanyS) {
            for (int i = 0; i < invoice.getEntryList().size(); i++) {
                InvoiceEntry temp = invoice.getEntryList().get(i);
                income = income.add(new BigDecimal(temp.getNettValue()));
                incomeVat = incomeVat.add(new BigDecimal(temp.getGrossValue() - temp.getNettValue()));
            }
        }
    }

    public List<BigDecimal> getValuesOfVatAndTurnover() {
        List<BigDecimal> temp = new ArrayList<>();
        temp.add(incomeVat);
        temp.add(outcomeVat);
        temp.add(income);
        temp.add(costs);
        return temp;
    }
}
