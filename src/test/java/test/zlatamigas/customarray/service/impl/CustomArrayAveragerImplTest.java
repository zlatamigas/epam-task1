package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArrayAverager;
import epam.zlatamigas.customarray.service.impl.CustomArrayAveragerImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomArrayAveragerImplTest {

    CustomArrayAverager arrayAverager;

    CustomArray emptyArray;
    CustomArray filledArray;

    double expectedInFilled;


    @BeforeClass
    public void setUp(){
        arrayAverager = new CustomArrayAveragerImpl();

        emptyArray = new CustomArray();
        filledArray = new CustomArray(3, 23, -2, 3, 0, 34, -12, 3);

        expectedInFilled = 6.5;
    }

    @Test
    public void testAverageNotEmpty() {

        try {
            double actual = arrayAverager.average(filledArray);

            assertEquals(actual, expectedInFilled);
        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAverageStreamNotEmpty() {

        try {
            double actual = arrayAverager.averageStream(filledArray);

            assertEquals(actual, expectedInFilled);
        } catch (CustomArrayException e) {
            fail(e.getMessage());
        }
    }

    @Test (expectedExceptions = CustomArrayException.class)
    public void testAverageEmpty() throws CustomArrayException {

        arrayAverager.average(emptyArray);
    }

    @Test (expectedExceptions = CustomArrayException.class)
    public void testAverageStreamEmpty() throws CustomArrayException {

        arrayAverager.averageStream(emptyArray);
    }
}