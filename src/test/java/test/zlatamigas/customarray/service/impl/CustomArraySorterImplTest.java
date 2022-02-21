package test.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArraySorter;
import epam.zlatamigas.customarray.service.impl.CustomArraySorterImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomArraySorterImplTest {

    CustomArraySorter arraySorter;

    @DataProvider(name = "arraysPr")
    public Object[][] createData() {
        return new Object[][]{
                { new int[]{23, -1, 43, 900, -7, 55, 12, 0}, new CustomArray(0, -7, -1, 0, 12, 23, 43, 55, 900)},
                { new int[]{900, 55, 43, 23, 12, 0, -1, -7}, new CustomArray(0, -7, -1, 0, 12, 23, 43, 55, 900)},
                { new int[]{-7}, new CustomArray(0, -7)},
                { new int[]{-7, -1, 0, 23, 12, 43, 55, 900}, new CustomArray(0, -7, -1, 0, 12, 23, 43, 55, 900)},
                { new int[]{}, new CustomArray(0)}
        };
    }

    @BeforeClass
    public void setUp() {
        arraySorter = new CustomArraySorterImpl();
    }


    @Test(dataProvider = "arraysPr")
    public void testBubbleSort(int[] arrayUnsorted, CustomArray expected) {
        CustomArray actual = new CustomArray(0, arrayUnsorted.clone());
        arraySorter.bubbleSort(actual);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arraysPr")
    public void testSelectionSort(int[] arrayUnsorted, CustomArray expected) {
        CustomArray actual = new CustomArray(0, arrayUnsorted.clone());
        arraySorter.selectionSort(actual);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "arraysPr")
    public void testMergeSort(int[] arrayUnsorted, CustomArray expected) {
        CustomArray actual = new CustomArray(0, arrayUnsorted.clone());
        arraySorter.mergeSort(actual);

        assertEquals(actual, expected);
    }
}