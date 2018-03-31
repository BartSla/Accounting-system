package pl.coderstrust.persistence;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class FileHelperTest {

    String pathNameForDatabase = "src/test/resources/database.json";

    private FileHelper fileHelper = new FileHelper(pathNameForDatabase);

    @Before
    public void beforeTest() {
        new File(pathNameForDatabase).delete();
    }

    @Test
    public void shouldWriteStringInFile() throws Exception {
        fileHelper.writeStringInFile("test");
        fileHelper.writeStringInFile("test");
        assertEquals(Arrays.asList("test", "test"), fileHelper.readInvoicesStringsFromFile());
    }

    @Test
    public void shouldReadInvoicesStringsFromFile() throws Exception {
        fileHelper.writeStringInFile("test");
        fileHelper.writeStringInFile("test");
        assertEquals(Arrays.asList("test", "test"), fileHelper.readInvoicesStringsFromFile());
    }

    @Test
    public void deleteFile() throws Exception {
        fileHelper.writeStringInFile("test");
        fileHelper.deleteFile();
        assertFalse(new File(pathNameForDatabase).exists());
    }
}