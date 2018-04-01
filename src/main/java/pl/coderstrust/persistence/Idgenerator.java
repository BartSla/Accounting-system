package pl.coderstrust.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

//TODO: The class is not used - if not needed, please remove. If needed, please rename to proper camel case: `IdGenerator`
public class Idgenerator {

    @Value("${invNumberPath}")
    String invNumberPath;

    @Value("${idFilePath}")
    String idFilePath;

    private static final Logger logger = LoggerFactory.getLogger(Idgenerator.class);

    public String invoiceNumber() {
        int lastId, lastYear, year;
        boolean saveNewYear;
        String newId;

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);

        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(invNumberPath))) {
            while (scanner.hasNextLine()) result.add(scanner.nextLine());
        } catch (IOException e) {
            logger.error("Couldn't read file InvNumber.txt", e);
        }
        lastId = Integer.parseInt(result.get(0));
        lastYear = Integer.parseInt(result.get(1));
        saveNewYear = year > lastYear;

        newId = lastId + 1 + "/" + year;

        try {
            new File(invNumberPath);
            PrintWriter save = new PrintWriter(invNumberPath);
            if (saveNewYear) {
                save.println(0);
                save.print(year);
            } else {
                save.println(lastId + 1);
                save.print(lastYear);
            }
            save.close();
        } catch (IOException e) {
            logger.error("Couldn't save invoice number", e);
        }
        return newId;
    }

    public int id() {
        int newID;
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(idFilePath))) {
            while (scanner.hasNextLine()) result.add(scanner.nextLine());
        } catch (IOException e) {
            logger.error("Couldn't read ID", e);
        }
        newID = Integer.parseInt(result.get(0)) + 1;
        try {
            new File(idFilePath);
            PrintWriter save = new PrintWriter(idFilePath);
            save.print(newID);
            save.close();
        } catch (IOException e) {
            logger.error("Couldn't save ID", e);
        }
        return newID;
    }
}
