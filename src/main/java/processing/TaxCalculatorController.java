package processing;

import persistence.InFileDatabase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorController {

    private BigDecimal incomeVat = new BigDecimal(0);
    private BigDecimal outcomeVat = new BigDecimal(0);
    private BigDecimal income = new BigDecimal(0);
    private BigDecimal costs = new BigDecimal(0);
    private BigDecimal income_cost = new BigDecimal(0);

    private InFileDatabase inFileDatabase = new InFileDatabase();
    private TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

    public List<BigDecimal> calculateTaxes() {
        for (int i = 0; i < inFileDatabase.getAllInvoices().size(); i++) {
            List<BigDecimal> temp;
            taxCalculatorService.visit(inFileDatabase.getAllInvoices().get(i));
            temp = taxCalculatorService.getValuesOfVatAndTurnover();
            incomeVat = incomeVat.add(temp.get(0));
            outcomeVat = outcomeVat.add(temp.get(1));
            income = income.add(temp.get(2));
            costs = costs.add(temp.get(3));
            temp.clear();
        }

        List<BigDecimal> temp2 = new ArrayList<>();
        income_cost = income.subtract(costs);
        temp2.add(incomeVat);
        temp2.add(outcomeVat);
        temp2.add(income);
        temp2.add(costs);
        temp2.add(income_cost);
        return temp2;
    }
}
