package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArraySummer;
import epam.zlatamigas.customarray.service.impl.CustomArraySummerImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomArraySummerImplTest {

    CustomArraySummer arraySummer;

    CustomArray emptyArray;
    CustomArray filledArray;

    double expectedInFilled;

    @BeforeClass
    public void setUp() {
        arraySummer = new CustomArraySummerImpl();

        emptyArray = new CustomArray();
        filledArray = new CustomArray(3, 23, -2, 3, 0, 34, -12, 3);

        expectedInFilled = 52;
    }


    @Test
    public void testSumNotEmpty() {

        try {
            double actual = arraySummer.sum(filledArray);

            assertEquals(actual, expectedInFilled);
        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSumStreamNotEmpty() {

        try {
            double actual = arraySummer.sumStream(filledArray);

            assertEquals(actual, expectedInFilled);
        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testSumEmpty() throws CustomArrayException {

        arraySummer.sum(emptyArray);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void testSumStreamEmpty() throws CustomArrayException {

        arraySummer.sumStream(emptyArray);
    }
}