package persistence;

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
    public void writeValueAsStringInFile() throws Exception {
        fileHelper.writeValueAsStringInFile("test");
        fileHelper.writeValueAsStringInFile("test");
        assertEquals(Arrays.asList("test", "test"), fileHelper.readValueFromJsonString());
    }

    @Test
    public void readValueFromJsonString() throws Exception {
        fileHelper.writeValueAsStringInFile("test");
        fileHelper.writeValueAsStringInFile("test");
        assertEquals(Arrays.asList("test", "test"), fileHelper.readValueFromJsonString());
    }

    @Test
    public void deleteFile() throws Exception {
        fileHelper.writeValueAsStringInFile("test");
        fileHelper.deleteFile();
        assertFalse(new File("src/test/resources/database.json").exists());
    }
}