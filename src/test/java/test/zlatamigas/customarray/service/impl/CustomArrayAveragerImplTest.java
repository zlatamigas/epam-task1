package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayAverager;
import epam.zlatamigas.customarray.service.impl.CustomArrayAveragerImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalDouble;

import static org.testng.Assert.assertEquals;

public class CustomArrayAveragerImplTest {

    CustomArrayAverager arrayAverager;

    @DataProvider(name = "arrayPr")
    public Object[][] createData() {
        return new Object[][]{
                {new CustomArray(3, 23, -2, 3, 0, 34, -12, 3), OptionalDouble.of(6.5)},
                {new CustomArray(), OptionalDouble.empty()}
        };
    }

    @BeforeClass
    public void setUp() {
        arrayAverager = new CustomArrayAveragerImpl();
    }

    @Test(dataProvider = "arrayPr")
    public void testAverageNotEmpty(CustomArray customArray, OptionalDouble expected) {

        OptionalDouble actual = arrayAverager.average(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayPr")
    public void testAverageStreamNotEmpty(CustomArray customArray, OptionalDouble expected) {

        OptionalDouble actual = arrayAverager.average(customArray);

        assertEquals(actual, expected);
    }

}