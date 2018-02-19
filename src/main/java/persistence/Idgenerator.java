package persistence;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Idgenerator {
    public String invoiceNumber() {
        int lastId, lastYear, year;
        boolean saveNewYear;
        String newId;

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);

        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src//main//invNumber.txt"))) {
            while (scanner.hasNextLine()) result.add(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        lastId = Integer.parseInt(result.get(0));
        lastYear = Integer.parseInt(result.get(1));
        saveNewYear = year > lastYear;

        newId = lastId + 1 + "/" + year;

        try {
            new File("src//main//invNumber.txt");
            PrintWriter zapis = new PrintWriter("src//main//invNumber.txt");
            if (saveNewYear) {
                zapis.println(0);
                zapis.print(year);
            } else {
                zapis.println(lastId + 1);
                zapis.print(lastYear);
            }
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public int id() {
        int newID;
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src//main//id.txt"))) {
            while (scanner.hasNextLine()) result.add(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        newID = Integer.parseInt(result.get(0)) + 1;
        try {
            new File("src//main//id.txt");
            PrintWriter zapis = new PrintWriter("src//main//id.txt");
            zapis.print(newID);
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newID;
    }
}
