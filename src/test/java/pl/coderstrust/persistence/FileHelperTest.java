package pl.coderstrust.persistence;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FileHelperTest {

    private FileHelper fileHelper = new FileHelper();

    @Before
    public void beforeTest() {
        new File("src/test/resources/database.json").delete();
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
        assertFalse(new File("src/test/resources/database.json").exists());
    }
}