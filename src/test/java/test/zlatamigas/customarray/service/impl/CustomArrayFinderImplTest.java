package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayFinder;
import epam.zlatamigas.customarray.service.impl.CustomArrayFinderImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class CustomArrayFinderImplTest {

    CustomArrayFinder arrayFinder;


    @DataProvider(name = "arrayMinPr")
    public Object[][] createDataForMin() {
        return new Object[][]{
                {new CustomArray(18, -29, 0, 29, 18), OptionalInt.of(-29)},
                {new CustomArray(), OptionalInt.empty()}
        };
    }

    @DataProvider(name = "arrayMaxPr")
    public Object[][] createDataForMax() {
        return new Object[][]{
                {new CustomArray(18, -29, 0, 29, 18), OptionalInt.of(29)},
                {new CustomArray(), OptionalInt.empty()}
        };
    }

    @BeforeClass
    public void setUp() {
        arrayFinder = new CustomArrayFinderImpl();
    }

    @Test(dataProvider = "arrayMinPr")
    public void testFindMin(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayFinder.findMin(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMinPr")
    public void testFindMinStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayFinder.findMinStream(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMaxPr")
    public void testFindMax(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayFinder.findMax(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayMaxPr")
    public void testFindMaxStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arrayFinder.findMaxStream(customArray);

        assertEquals(actual, expected);
    }

}