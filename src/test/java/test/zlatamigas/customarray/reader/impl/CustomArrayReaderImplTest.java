package test.zlatamigas.customarray.reader.impl;

import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.reader.CustomArrayReader;
import epam.zlatamigas.customarray.reader.impl.CustomArrayReaderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomArrayReaderImplTest {

    static final String ARRAYS_PATH = "testarrays\\";

    CustomArrayReader arrayReader;

    @BeforeClass
    public void setUp() {
        arrayReader = new CustomArrayReaderImpl();
    }

    @DataProvider(name = "arrayFilesPr")
    public Object[][] createData() {
        return new Object[][]{
                {"0.txt", ""},
                {"1.txt", ""},
                {"2.txt", "+1 -23 3"},
                {"3.txt", "+01 -23 3"},
                {"4.txt", "-23 +23 12"},
                {"5.txt", "-23 +23 12"}
        };
    }

    @Test(dataProvider = "arrayFilesPr")
    public void testReadExistingValid(String fileName, String expected) {
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(ARRAYS_PATH + fileName);
            File file = new File(resource.toURI());

            CustomArrayReader arrayReader = new CustomArrayReaderImpl();
            String actual = arrayReader.readArrayStrFromFile(file.getAbsolutePath());

            assertEquals(actual, expected);
        } catch (CustomArrayException | URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadExistingInvalid() throws CustomArrayException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ARRAYS_PATH + "invalid.txt");

        try {
            File file = new File(resource.toURI());
            CustomArrayReader arrayReader = new CustomArrayReaderImpl();

            String actual = arrayReader.readArrayStrFromFile(file.getAbsolutePath());

        } catch (URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadNotExisting() throws CustomArrayException {

        String actual = arrayReader.readArrayStrFromFile(ARRAYS_PATH + "notexisting.txt");
    }
}