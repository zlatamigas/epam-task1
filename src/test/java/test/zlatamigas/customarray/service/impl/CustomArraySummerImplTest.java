package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArraySummer;
import epam.zlatamigas.customarray.service.impl.CustomArraySummerImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class CustomArraySummerImplTest {

    CustomArraySummer arraySummer;

    @DataProvider(name = "arrayPr")
    public Object[][] createData() {
        return new Object[][]{
                {new CustomArray(3, 23, -2, 3, 0, 34, -12, 3), OptionalInt.of(52)},
                {new CustomArray(), OptionalInt.empty()}
        };
    }

    @BeforeClass
    public void setUp() {
        arraySummer = new CustomArraySummerImpl();
    }


    @Test(dataProvider = "arrayPr")
    public void testSum(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arraySummer.sum(customArray);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arrayPr")
    public void testSumStream(CustomArray customArray, OptionalInt expected) {

        OptionalInt actual = arraySummer.sumStream(customArray);

        assertEquals(actual, expected);
    }

}