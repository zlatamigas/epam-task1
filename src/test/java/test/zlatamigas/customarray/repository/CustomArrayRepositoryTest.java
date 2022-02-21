package test.zlatamigas.customarray.repository;

import epam.zlatamigas.customarray.comparator.CustomArrayFirstElementComparator;
import epam.zlatamigas.customarray.comparator.CustomArrayIdComparator;
import epam.zlatamigas.customarray.comparator.CustomArraySizeComparator;
import epam.zlatamigas.customarray.config.CustomArrayRepositoryConfigurator;
import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepository;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;
import epam.zlatamigas.customarray.repository.impl.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CustomArrayRepositoryTest {

    private CustomArrayRepositoryConfigurator configurator;
    private CustomArrayRepository repository;

    private CustomArray[] arrays = {
            new CustomArray(1),
            new CustomArray(3, 1, 90, 34),
            new CustomArray(78, 20, -34, 9, 8, 23),
            new CustomArray(2, 3)
    };

    @BeforeClass
    public void setUp() {
        repository = CustomArrayRepository.getInstance();
        configurator = new CustomArrayRepositoryConfigurator();

        for (CustomArray array : arrays) {
            configurator.addToRepository(array);
        }
    }

    @Test
    public void testQueryAvgSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[1]);

        CustomArrayRepositorySpecification specification =
                new RepositoryAvgSpecification(20, NumericSpecificationDegree.GREATER);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryIdEqualsSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[2]);

        CustomArrayRepositorySpecification specification =
                new RepositoryIdEqualsSpecification(78);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryIdIntervalSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[1]);
        expected.add(arrays[3]);

        CustomArrayRepositorySpecification specification =
                new RepositoryIdIntervalSpecification(2, 3);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryMaxSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[1]);
        expected.add(arrays[2]);
        expected.add(arrays[3]);

        CustomArrayRepositorySpecification specification =
                new RepositoryMaxSpecification(100, NumericSpecificationDegree.LESS);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[3]);

        CustomArrayRepositorySpecification specification =
                new RepositoryMinSpecification(3, NumericSpecificationDegree.GREATER_OR_EQUALS);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQuerySizeSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[0]);
        expected.add(arrays[1]);
        expected.add(arrays[3]);

        CustomArrayRepositorySpecification specification =
                new RepositorySizeSpecification(3, NumericSpecificationDegree.LESS_OR_EQUALS);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testQuerySumSpecification() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[0]);
        expected.add(arrays[2]);
        expected.add(arrays[3]);

        CustomArrayRepositorySpecification specification =
                new RepositorySumSpecification(125, NumericSpecificationDegree.NOT_EQUALS);
        List<CustomArray> actual = repository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void testSortFirstElement() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[0]);
        expected.add(arrays[1]);
        expected.add(arrays[3]);
        expected.add(arrays[2]);

        repository.sort(new CustomArrayFirstElementComparator());

        List<CustomArray> actual = repository.getItems();

        assertEquals(actual, expected);
    }

    @Test
    public void testSortId() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[0]);
        expected.add(arrays[3]);
        expected.add(arrays[1]);
        expected.add(arrays[2]);

        repository.sort(new CustomArrayIdComparator());

        List<CustomArray> actual = repository.getItems();

        assertEquals(actual, expected);
    }

    @Test
    public void testSortSize() {
        List<CustomArray> expected = new ArrayList<>();
        expected.add(arrays[0]);
        expected.add(arrays[3]);
        expected.add(arrays[1]);
        expected.add(arrays[2]);

        repository.sort(new CustomArraySizeComparator());

        List<CustomArray> actual = repository.getItems();

        assertEquals(actual, expected);
    }
}