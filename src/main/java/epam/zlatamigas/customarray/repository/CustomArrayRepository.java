package epam.zlatamigas.customarray.repository;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.repository.impl.RepositoryIdEqualsSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CustomArrayRepository {

    private static CustomArrayRepository instance;

    private List<CustomArray> items;

    private CustomArrayRepository() {
        this.items = new ArrayList<>();
    }

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public List<CustomArray> getItems() {
        return items;
    }

    public boolean add(CustomArray customArray) {
        int id = customArray.getId();
        List<CustomArray> arraysWithEqualId = query(new RepositoryIdEqualsSpecification(id));

        if (!arraysWithEqualId.isEmpty()) {
            return false;
        }

        return items.add(customArray);
    }

    public boolean remove(CustomArray customArray) {
        return items.remove(customArray);
    }

    public boolean remove(int arrayId) {

        List<CustomArray> arraysWithEqualId = query(new RepositoryIdEqualsSpecification(arrayId));

        if (arraysWithEqualId.isEmpty()) {
            return false;
        }

        CustomArray customArray = arraysWithEqualId.get(0);
        return items.remove(customArray);
    }

    public CustomArray get(int arrayId) throws CustomArrayException {

        List<CustomArray> arraysWithEqualId = query(new RepositoryIdEqualsSpecification(arrayId));

        if (arraysWithEqualId.isEmpty()) {
            throw new CustomArrayException("No CustomArray in Repository with id=" + arrayId);
        }

        return arraysWithEqualId.get(0);
    }

    public CustomArray set(CustomArray customArray) {

        List<CustomArray> arraysWithEqualId = query(new RepositoryIdEqualsSpecification(customArray.getId()));

        CustomArray existingCustomArray = null;
        if (!arraysWithEqualId.isEmpty()) {
            existingCustomArray = arraysWithEqualId.get(0);
            items.remove(existingCustomArray);
        }
        items.add(customArray);


        return existingCustomArray;
    }

    public List<CustomArray> query(CustomArrayRepositorySpecification specification) {
        List<CustomArray> list = items.stream().filter(specification::specify).toList();
        return list;
    }

    public List<CustomArray> query(Predicate<CustomArray> specification) {
        List<CustomArray> list = items.stream().filter(specification).toList();
        return list;
    }

    public void sort(Comparator<? super CustomArray> comparator) {
        items.sort(comparator);
    }
}
