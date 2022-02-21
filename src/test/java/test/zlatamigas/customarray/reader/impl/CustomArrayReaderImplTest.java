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
import java.util.Arrays;

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
    public Object[][] createDataSingleArray() {
        return new Object[][]{
                {"0.txt", ""},
                {"1.txt", ""},
                {"2.txt", "+1 -23 3"},
                {"3.txt", "+01 -23 3"},
                {"4.txt", "-23 +23 12"},
                {"5.txt", "-23 +23 12"}
        };
    }

    @DataProvider(name = "allArraysFilesPr")
    public Object[][] createDataAllArrays() {
        return new Object[][]{
                {"0.txt", new String[0]},
                {"1.txt", new String[]{""}},
                {"2.txt", new String[]{"+1 -23 3", "4 5 6 6"}},
                {"3.txt", new String[]{"+01 -23 3"}},
                {"6.txt", new String[]{" 6 7 8", "3 -4 +0512 09", "1 -2 3", "123 456 -23", "", "0"}}
        };
    }


    @Test(dataProvider = "arrayFilesPr")
    public void testReadArrayStrFromFileExistingValid(String fileName, String expected) {
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(ARRAYS_PATH + fileName);
            File file = new File(resource.toURI());

            String actual = arrayReader.readArrayStrFromFile(file.getAbsolutePath());

            assertEquals(actual, expected);
        } catch (CustomArrayException | URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadArrayStrFromFileExistingInvalid() throws CustomArrayException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ARRAYS_PATH + "invalid.txt");

        try {

            File file = new File(resource.toURI());
            arrayReader.readArrayStrFromFile(file.getAbsolutePath());

        } catch (URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadArrayStrFromFileNotExisting() throws CustomArrayException {

        arrayReader.readArrayStrFromFile(ARRAYS_PATH + "notexisting.txt");
    }

    @Test(dataProvider = "allArraysFilesPr")
    public void testReadAllArraysStrFromFileExistingValid(String fileName, String[] expected) {
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(ARRAYS_PATH + fileName);
            File file = new File(resource.toURI());

            String[] actual = arrayReader.readAllArraysStrFromFile(file.getAbsolutePath());

            assertEquals(actual, expected);
        } catch (CustomArrayException | URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArraysStrFromFileExistingInvalid() throws CustomArrayException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(ARRAYS_PATH + "invalid.txt");

        try {

            File file = new File(resource.toURI());
            arrayReader.readAllArraysStrFromFile(file.getAbsolutePath());

        } catch (URISyntaxException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testReadAllArraysStrFromFileNotExisting() throws CustomArrayException {
        arrayReader.readAllArraysStrFromFile(ARRAYS_PATH + "notexisting.txt");
    }
}