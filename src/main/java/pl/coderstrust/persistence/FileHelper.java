package pl.coderstrust.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FileHelper {

    private File file = new File("src/test/resources/database.json");

    //TODO: Method name is confusing - I would rather suggest `writeInvoiceStringToFile` or just `writeStringToFile, as you already have it as String in here
    public void writeValueAsStringInFile(String invoice) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(invoice);
            writer.newLine();
        }
    }

    //TODO: It has nothing to do with JSON so again name is confusing. It should be rather: `readInvoicesStringsFromFile` or just `readLinesFromFile`
    public List<String> readValueFromJsonString() throws IOException {
        List<String> readLines = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                readLines.add(scanner.nextLine());
            }
        }
        return readLines;
    }

    public void deleteFile() {
        file.delete();
    }
}