package pl.coderstrust.processing;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import pl.coderstrust.domain.Invoice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PdfService {

    public String savePdf(Invoice invoice) throws FileNotFoundException, com.itextpdf.text.DocumentException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss");
        Date date = new Date();
        Document doc = new Document();
        String path = "C:/Users/" + System.getProperty("user.name") + "/Downloads/Invoice" + invoice.getId() + ".pdf";
        File file = new File(path);
        FileOutputStream pdfFileout = new FileOutputStream(file);
        PdfWriter.getInstance(doc, pdfFileout);
        Paragraph ParDate = new Paragraph(dateFormat.format(date));
        Paragraph empty = new Paragraph(" ");
        doc.open();
        doc.add(ParDate);
        doc.add(empty);
        addDate(doc,invoice);
        doc.add(empty);
        addBuyer(doc,invoice);
        doc.add(empty);
        addSeller(doc,invoice);
        doc.add(empty);
        addEntryList(doc,invoice);
        doc.close();
        return path;
    }
    private void addEntryList(Document doc,Invoice invoice) throws DocumentException {
        for (int i = 0; i < invoice.getEntryList().size(); i++) {
            Paragraph EntryNumber = new Paragraph("Entry " + i + ":");
            Paragraph EntryName = new Paragraph("Name:" + invoice.getEntryList().get(i).getName());
            Paragraph EntryVat = new Paragraph("Vat:" + invoice.getEntryList().get(i).getVat());
            Paragraph EntryGrossValue = new Paragraph("Gross value:" + invoice.getEntryList().get(i).getGrossValue());
            Paragraph EntryNettValue= new Paragraph("Nett value:" + invoice.getEntryList().get(i).getNettValue());
            Paragraph empty = new Paragraph(" ");
            doc.add(EntryNumber);
            doc.add(EntryName);
            doc.add(EntryVat);
            doc.add(EntryGrossValue);
            doc.add(EntryNettValue);
            doc.add(empty);
        }
    }


    private void addDate(Document doc,Invoice invoice) throws DocumentException {
        Paragraph SaveDate = new Paragraph("Invoice save date: " + invoice.getDate().toString());
        doc.add(SaveDate);
    }

    private void addBuyer(Document doc,Invoice invoice) throws DocumentException {
        Paragraph Buyer = new Paragraph("Buyer:");
        Paragraph BuyerName = new Paragraph("Name: " +invoice.getBuyer().getName());
        Paragraph BuyerNip = new Paragraph("Nip: " +invoice.getBuyer().getNip());
        Paragraph BuyerStreetAndNumber = new Paragraph("Street and number: " +invoice.getBuyer().getStreetAndNumber());
        Paragraph BuyerCity = new Paragraph("City: " +invoice.getBuyer().getCity());
        Paragraph BuyerPostcode = new Paragraph("Postcode: " + invoice.getBuyer().getPostcode());
        doc.add(Buyer);
        doc.add(BuyerName);
        doc.add(BuyerNip);
        doc.add(BuyerStreetAndNumber);
        doc.add(BuyerCity);
        doc.add(BuyerPostcode);

    }
    private void addSeller(Document doc,Invoice invoice) throws DocumentException {
        Paragraph Seller = new Paragraph("Seller:");
        Paragraph SellerName = new Paragraph("Name: " +invoice.getSeller().getName());
        Paragraph SellerNip = new Paragraph("Nip: " +invoice.getSeller().getNip());
        Paragraph SellerStreetAndNumber = new Paragraph("Street and number: " +invoice.getSeller().getStreetAndNumber());
        Paragraph SellerCity = new Paragraph("City: " +invoice.getSeller().getCity());
        Paragraph SellerPostcode = new Paragraph("Postcode: " + invoice.getSeller().getPostcode());
        doc.add(Seller);
        doc.add(SellerName);
        doc.add(SellerNip);
        doc.add(SellerStreetAndNumber);
        doc.add(SellerCity);
        doc.add(SellerPostcode);
    }
}
