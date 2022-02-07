package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayChanger;
import epam.zlatamigas.customarray.service.impl.CustomArrayChangerImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomArrayChangerImplTest {

    CustomArrayChanger arrayChanger;

    @BeforeClass
    public void setUp(){
        arrayChanger = new CustomArrayChangerImpl();
    }

    @Test
    public void testChangeSign() {

        CustomArray actual = new CustomArray(1, 2, -3, 0 ,5 ,9);
        arrayChanger.changeSign(actual);

        CustomArray expected = new CustomArray(-1, -2, 3, 0 ,-5 ,-9);

        assertEquals(actual, expected);
    }

    @Test
    public void testChangeSignStream() {
        CustomArray actual = new CustomArray(1, 2, -3, 0 ,5 ,9);
        arrayChanger.changeSignStream(actual);

        CustomArray expected = new CustomArray(-1, -2, 3, 0 ,-5 ,-9);

        assertEquals(actual, expected);
    }
}