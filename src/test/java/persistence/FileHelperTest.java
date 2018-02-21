package persistence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileHelperTest {
     FileHelper fileHelper = new FileHelper();
    @Test
    public void writeValueAsStringInFile() throws Exception {
        fileHelper.writeValueAsStringInFile("test");
        assertEquals("test", fileHelper.readValueFromJsonString());
    }

    @Test
    public void readValueFromJsonString() throws Exception {
        assertEquals("test", fileHelper.readValueFromJsonString());
    }

    @Test
    public void deleteFile() throws Exception {
      fileHelper.deleteFile();
      assertEquals(true, fileHelper.readValueFromJsonString().isEmpty());
    }

}