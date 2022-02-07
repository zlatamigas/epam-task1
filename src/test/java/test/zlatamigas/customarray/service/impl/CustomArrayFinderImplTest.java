package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArrayFinder;
import epam.zlatamigas.customarray.service.impl.CustomArrayFinderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomArrayFinderImplTest {

    CustomArrayFinder arrayFinder;

    @BeforeClass
    public void setUp() {
        arrayFinder = new CustomArrayFinderImpl();
    }


    @Test
    public void testFindMinNotEmpty() {

        CustomArray customArray = new CustomArray(18, -29, 0, 29, 18);
        try {
            long actual = arrayFinder.findMin(customArray);
            long expected = -29;

            assertEquals(actual, expected);

        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }

    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinEmpty() throws CustomArrayException {

        CustomArray customArray = new CustomArray();
        arrayFinder.findMin(customArray);
    }


    @Test
    public void testFindMinStreamNotEmpty() {

        CustomArray customArray = new CustomArray(18, -29, 0, 29, 18);
        try {
            long actual = arrayFinder.findMinStream(customArray);
            long expected = -29;

            assertEquals(actual, expected);

        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }

    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMinStreamEmpty() throws CustomArrayException {

        CustomArray customArray = new CustomArray();
        arrayFinder.findMinStream(customArray);
    }


    @Test
    public void testFindMaxNotEmpty() {

        CustomArray customArray = new CustomArray(18, -29, 0, 29, 18);
        try {
            long actual = arrayFinder.findMax(customArray);
            long expected = 29;

            assertEquals(actual, expected);

        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }

    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxEmpty() throws CustomArrayException {

        CustomArray customArray = new CustomArray();
        arrayFinder.findMax(customArray);
    }


    @Test
    public void testFindMaxStreamNotEmpty() {

        CustomArray customArray = new CustomArray(18, -29, 0, 29, 18);
        try {
            long actual = arrayFinder.findMaxStream(customArray);
            long expected = 29;

            assertEquals(actual, expected);

        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }

    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testFindMaxStreamEmpty() throws CustomArrayException {

        CustomArray customArray = new CustomArray();
        arrayFinder.findMaxStream(customArray);
    }

}