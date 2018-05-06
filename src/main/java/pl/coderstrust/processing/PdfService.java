package pl.coderstrust.processing;

import com.itextpdf.text.Document;
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
        //Date
        Paragraph ParDate = new Paragraph(dateFormat.format(date));
        //Invoice save date
        Paragraph SaveDate = new Paragraph("Invoice save date: " + invoice.getDate().toString());
        //Buyer
        Paragraph Buyer = new Paragraph("Buyer:");
        Paragraph BuyerName = new Paragraph("Name: " +invoice.getBuyer().getName());
        Paragraph BuyerNip = new Paragraph("Nip: " +invoice.getBuyer().getNip());
        Paragraph BuyerStreetAndNumber = new Paragraph("Street and number: " +invoice.getBuyer().getStreetAndNumber());
        Paragraph BuyerCity = new Paragraph("City: " +invoice.getBuyer().getCity());
        Paragraph BuyerPostcode = new Paragraph("Postcode: " + invoice.getBuyer().getPostcode());
        //Seller
        Paragraph Seller = new Paragraph("Seller:");
        Paragraph SellerName = new Paragraph("Name: " +invoice.getSeller().getName());
        Paragraph SellerNip = new Paragraph("Nip: " +invoice.getSeller().getNip());
        Paragraph SellerStreetAndNumber = new Paragraph("Street and number: " +invoice.getSeller().getStreetAndNumber());
        Paragraph SellerCity = new Paragraph("City: " +invoice.getSeller().getCity());
        Paragraph SellerPostcode = new Paragraph("Postcode: " + invoice.getSeller().getPostcode());
        //Empty Line
        Paragraph empty = new Paragraph(" ");
        doc.open();
        //Adding date
        doc.add(ParDate);
        doc.add(empty);
        //Adding invoice save date
        doc.add(SaveDate);
        doc.add(empty);
        //Adding buyer to document
        doc.add(Buyer);
        doc.add(BuyerName);
        doc.add(BuyerNip);
        doc.add(BuyerStreetAndNumber);
        doc.add(BuyerCity);
        doc.add(BuyerPostcode);
        doc.add(empty);
        //Adding seller to document
        doc.add(Seller);
        doc.add(SellerName);
        doc.add(SellerNip);
        doc.add(SellerStreetAndNumber);
        doc.add(SellerCity);
        doc.add(SellerPostcode);
        doc.add(empty);
        for (int i = 0; i < invoice.getEntryList().size(); i++) {
            Paragraph EntryNumber = new Paragraph("Entry " + i + ":");
            Paragraph EntryName = new Paragraph("Name:" + invoice.getEntryList().get(i).getName());
            Paragraph EntryVat = new Paragraph("Vat:" + invoice.getEntryList().get(i).getVat());
            Paragraph EntryGrossValue = new Paragraph("Gross value:" + invoice.getEntryList().get(i).getGrossValue());
            Paragraph EntryNettValue= new Paragraph("Nett value:" + invoice.getEntryList().get(i).getNettValue());
            doc.add(EntryNumber);
            doc.add(EntryName);
            doc.add(EntryVat);
            doc.add(EntryGrossValue);
            doc.add(EntryNettValue);
            doc.add(empty);
        }
        doc.add(empty);
        doc.close();
        return path;
    }
}
