package test.zlatamigas.customarray.parser.impl;

import epam.zlatamigas.customarray.parser.CustomArrayParser;
import epam.zlatamigas.customarray.parser.impl.CustomArrayParserImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomArrayParserImplTest {

    CustomArrayParser arrayParser;

    @BeforeClass
    public void setUp() {
        arrayParser = new CustomArrayParserImpl();
    }

    @DataProvider(name = "arraysPr")
    public Object[][] createData() {
        return new Object[][]{
                {"", new int[0]},
                {"", new int[0]},
                {"+1 -23 3", new int[]{1, -23, 3}},
                {"+01 -23 3", new int[]{1, -23, 3}},
                {"-23 +23 12", new int[]{-23, 23, 12}},
                {"-23 +23 12", new int[]{-23, 23, 12}}
        };
    }

    @Test(dataProvider = "arraysPr")
    public void testParse(String arrayStr, int[] expected) {
        int[] actual = arrayParser.parse(arrayStr);

        assertEquals(actual, expected);
    }
}