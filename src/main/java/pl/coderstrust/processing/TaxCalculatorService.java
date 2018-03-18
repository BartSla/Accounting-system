package pl.coderstrust.processing;

import pl.coderstrust.domain.Buyer;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.domain.InvoiceEntry;
import pl.coderstrust.domain.Seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**FIXME: This is wrong: you should have separate Visitors for different kinds of taxes - each Visitor should count one particular kind of tax and return it.
 * You cannot keep the tax values in fields and then have another method read the fields, as you have no control on how the user is calling the methods,
 * so he can be getting wrong results.
*/
public class TaxCalculatorService implements Visitor {
    private BigDecimal incomeVat = new BigDecimal(0);
    private BigDecimal outcomeVat = new BigDecimal(0);
    private BigDecimal income = new BigDecimal(0);
    private BigDecimal costs = new BigDecimal(0);

    //TODO: Actually I found it redundant or too much complicated. You have only one company, and you just check whether it is a buyer or seller in the invoice -
    //you do not need additional classes that do nothing but just opaque Company to name it Buyer or Seller - there in neither no sens nor additional logic in that
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
