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
import org.springframework.stereotype.Service;

@Service
public class FileHelper {

    private File file = new File("src/test/resources/database.json");

    public void writeStringInFile(String invoice) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(invoice);
            writer.newLine();
        }
    }

    public List<String> readInvoicesStringsFromFile() throws IOException {
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