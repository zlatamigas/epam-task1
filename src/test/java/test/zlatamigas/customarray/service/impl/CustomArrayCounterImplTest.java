package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class CustomArrayCounterImplTest {

    CustomArrayCounter arrayCounter;

    @DataProvider(name = "arrayAvgPr")
    public Object[][] createDataForAvg() {
        return new Object[][]{
                {new CustomArray(0, 23, -2, 3, 0, 34, -12, 3), OptionalDouble.of(7)},
                {new CustomArray(0), OptionalDouble.empty()}
        };
    }

    @DataProvider(name = "arrayMinPr")
    public Object[][] createDataForMin() {
        return new Object[][]{
                {new CustomArray(0, 18, -29, 0, 29, 18), OptionalInt.of(-29)},
                {new CustomArray(0), OptionalInt.empty()}
        };
    }

    @DataProvider(name = "arrayMaxPr")
    public Object[][] createDataForMax() {
        return new Object[][]{
                {new CustomArray(0, 18, -29, 0, 29, 18), OptionalInt.of(29)},
                {new CustomArray(0), OptionalInt.empty()}
        };
    }

    @DataProvider(name = "arraySumPr")
    public Object[][] createDataForSum() {
        return new Object[][]{
                {new CustomArray(0, 3, 23, -2, 3, 0, 34, -12, 3), OptionalInt.of(52)},
                {new CustomArray(0), OptionalInt.empty()}
        };
    }



    @BeforeClass
    public void setUp(){
        arrayCounter = new CustomArrayCounterImpl();
    }


    @Test
    public void testCountPositiveEmpty() {

        CustomArray customArray = new CustomArray(0);
        long actual = arrayCounter.countPositive(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveNotEmpty() {

        CustomArray customArray = new CustomArray(0, -2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countPositive(customArray);
        long expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveNoNumbers() {

        CustomArray customArray = new CustomArray(0, -2, -2, -1, -1, 0, -3);
        long actual = arrayCounter.countPositive(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountPositiveStreamEmpty() {

        CustomArray customArray = new CustomArray(0);
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveStreamNotEmpty() {

        CustomArray customArray = new CustomArray(0, -2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositiveStreamNoNumbers() {

        CustomArray customArray = new CustomArray(0, -2, -2, -1, -1, 0, -3);
        long actual = arrayCounter.countPositiveStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountNegativeEmpty() {

        CustomArray customArray = new CustomArray(0);
        long actual = arrayCounter.countNegative(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeNotEmpty() {

        CustomArray customArray = new CustomArray(0, -2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countNegative(customArray);
        long expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeNoNumbers() {

        CustomArray customArray = new CustomArray(0, 2, 2, 1, 1, 0, 3);
        long actual = arrayCounter.countNegative(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }


    @Test
    public void testCountNegativeStreamEmpty() {

        CustomArray customArray = new CustomArray(0);
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeStreamNotEmpty() {

        CustomArray customArray = new CustomArray(0, -2, 2, 1, -1, 0, 3);
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    public void testCountNegativeStreamNoNumbers() {

        CustomArray customArray = new CustomArray(0, 2, 2, 1, 1, 0, 3);
        long actual = arrayCounter.countNegativeStream(customArray);
        long expected = 0;

        assertEquals(actual, expected);
    }



    @Test(dataProvider = "arrayAvgPr")
    public void testAverageNotEmpty(CustomArray customArray, OptionalDouble expected) {

        OptionalDouble actual = arrayCounter.average(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayAvgPr")
    public void testAverageStreamNotEmpty(CustomArray customArray, OptionalDouble expected) {

        OptionalDouble actual = arrayCounter.average(customArray);

        assertEquals(actual, expected);
    }



    @Test(dataProvider = "arrayMinPr")
    public void testFindMin(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.min(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMinPr")
    public void testFindMinStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.minStream(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMaxPr")
    public void testFindMax(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.max(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMaxPr")
    public void testFindMaxStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.maxStream(customArray);

        assertEquals(actual, expected);
    }



    @Test(dataProvider = "arraySumPr")
    public void testSum(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.sum(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arraySumPr")
    public void testSumStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayCounter.sumStream(customArray);

        assertEquals(actual, expected);
    }
}