package test.zlatamigas.customarray.observer.impl;

import epam.zlatamigas.customarray.config.CustomArrayRepositoryConfigurator;
import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.entity.CustomArrayParameters;
import epam.zlatamigas.customarray.entity.CustomArrayWarehouse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class CustomArrayObserverImplTest {

    private CustomArrayRepositoryConfigurator configurator;
    private CustomArrayWarehouse warehouse;
    private CustomArray array = new CustomArray(1, 1, 2, 4, 4, 5);

    @BeforeClass
    public void setUp() {
        warehouse = CustomArrayWarehouse.getInstance();
        configurator = new CustomArrayRepositoryConfigurator();
    }

    @Test
    public void testParameterChanged() {
        configurator.addToRepository(array);

        array.setArray(1, 2, 3, 4, 5);

        CustomArrayParameters expected = new CustomArrayParameters(
                OptionalInt.of(5), OptionalInt.of(1), OptionalInt.of(15), OptionalDouble.of(3));

        int id = array.getId();
        CustomArrayParameters actual = warehouse.get(id);

        assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() {
        configurator.removeFromRepository(array);
    }
}