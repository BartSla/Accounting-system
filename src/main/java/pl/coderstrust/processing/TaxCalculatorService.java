package pl.coderstrust.processing;

import org.springframework.stereotype.Service;
import pl.coderstrust.domain.Company;
import pl.coderstrust.domain.Invoice;
import pl.coderstrust.domain.InvoiceEntry;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Service
public class TaxCalculatorService {

    private Company myCompanyS = new Company("ABC1", "896", "New1", "Wroclaw", "55-120");

    private BigDecimal getGeneric(List<Invoice> invoices, Function<Invoice, Boolean> shouldFunction, Function<InvoiceEntry, BigDecimal> getValueFunction ) {
        BigDecimal sumOfVat = new BigDecimal(0);
        for (int j = 0; j < invoices.size(); j++) {
            if (shouldFunction.apply(invoices.get(j))){
                for (int i = 0; i < invoices.get(j).getEntryList().size(); i++) {
                    InvoiceEntry invoiceEntry = invoices.get(j).getEntryList().get(i);
                    sumOfVat = sumOfVat.add(getValueFunction.apply(invoiceEntry));
                }
            }
        }
        return sumOfVat;
    }

    public BigDecimal getOutcomeVat(List<Invoice> invoices) {
       return  getGeneric(invoices, invoice -> invoice.getBuyer().equals(myCompanyS), invoiceEntry -> invoiceEntry.getNettValue().multiply(new BigDecimal(invoiceEntry.getVat().getValue())).divide(BigDecimal.valueOf(100),2));
    }

    public BigDecimal getIncomeVat(List<Invoice> invoices) {
        return  getGeneric(invoices, invoice -> invoice.getSeller().equals(myCompanyS), invoiceEntry -> invoiceEntry.getNettValue().multiply(new BigDecimal(invoiceEntry.getVat().getValue())).divide(BigDecimal.valueOf(100),2));
    }

    public BigDecimal getIncome(List<Invoice> invoices) {
        return getGeneric(invoices, invoice -> invoice.getSeller().equals(myCompanyS), invoiceEntry -> invoiceEntry.getNettValue());
    }

    public  BigDecimal getOutcome(List<Invoice> invoices) {
        return getGeneric(invoices, invoice -> invoice.getBuyer().equals(myCompanyS), invoiceEntry -> invoiceEntry.getNettValue());
    }
}