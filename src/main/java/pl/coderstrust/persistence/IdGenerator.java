package pl.coderstrust.persistence;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TODO: The class is not used - if not needed, please remove. If needed, please rename to proper camel case: `IdGenerator`
public class IdGenerator {
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
            PrintWriter save = new PrintWriter("src//main//id.txt");
            save.print(newID);
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newID;
    }
}
