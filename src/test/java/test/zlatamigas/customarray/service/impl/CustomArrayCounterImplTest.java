package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomArrayCounterImplTest {

    CustomArrayCounter arrayCounter;


    @BeforeClass
    public void setUp(){
        arrayCounter = new CustomArrayCounterImpl();
    }


    @Test
    public void testCountPositiveEmpty() {

        CustomArray customArray = new CustomArray();
        long actual = arrayCounter.countPositive(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveNotEmpty() {

        CustomArray customArray = new CustomArray(-2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countPositive(customArray);
        long expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveNoNumbers() {

        CustomArray customArray = new CustomArray(-2, -2, -1, -1, 0, -3);
        long actual = arrayCounter.countPositive(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountPositiveStreamEmpty() {

        CustomArray customArray = new CustomArray();
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveStreamNotEmpty() {

        CustomArray customArray = new CustomArray(-2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveStreamNoNumbers() {

        CustomArray customArray = new CustomArray(-2, -2, -1, -1, 0, -3);
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountNegativeEmpty() {

        CustomArray customArray = new CustomArray();
        long actual = arrayCounter.countNegative(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeNotEmpty() {

        CustomArray customArray = new CustomArray(-2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countNegative(customArray);
        long expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeNoNumbers() {

        CustomArray customArray = new CustomArray(2, 2, 1, 1, 0, 3);
        long actual = arrayCounter.countNegative(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountNegativeStreamEmpty() {

        CustomArray customArray = new CustomArray();
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeStreamNotEmpty() {

        CustomArray customArray = new CustomArray(-2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeStreamNoNumbers() {

        CustomArray customArray = new CustomArray(2, 2, 1, 1, 0, 3);
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }
}