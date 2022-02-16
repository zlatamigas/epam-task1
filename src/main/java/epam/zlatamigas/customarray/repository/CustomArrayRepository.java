package epam.zlatamigas.customarray.repository;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.entity.CustomArrayWarehouse;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.observer.CustomArrayObserver;
import epam.zlatamigas.customarray.observer.impl.CustomArrayObserverImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomArrayRepository {

    private static final CustomArrayObserver OBSERVER = new CustomArrayObserverImpl();

    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
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

    public boolean contains(int arrayId){
        return findCustomArrayWithId(arrayId) != null;
    }

    public boolean add(CustomArray customArray) {
        int id = customArray.getId();
        if(findCustomArrayWithId(id)!=null){
            return false;
        }
        customArray.attach(OBSERVER);
        customArray.notifyObservers();
        return items.add(customArray);
    }

    public boolean remove(CustomArray customArray) {
        customArray.detach(OBSERVER);
        warehouse.remove(customArray.getId());
        return items.remove(customArray);
    }

    public boolean remove(int arrayId) {
        CustomArray customArray = findCustomArrayWithId(arrayId);
        if(customArray==null){
            return false;
        }
        customArray.detach(OBSERVER);
        warehouse.remove(customArray.getId());
        return items.remove(customArray);
    }

    public boolean addAll(Collection<? extends CustomArray> customArrays) {
        customArrays.forEach(customArray -> {
            customArray.attach(OBSERVER);
            customArray.notifyObservers();
        });
        return items.addAll(customArrays);
    }

    public boolean removeAll(Collection<? extends CustomArray> customArrays) {
        customArrays.forEach(customArray -> {
            customArray.detach(OBSERVER);
            warehouse.remove(customArray.getId());
        });
        return items.removeAll(customArrays);
    }

    public CustomArray get(int arrayId) throws CustomArrayException {
        CustomArray customArray = findCustomArrayWithId(arrayId);
        if (customArray == null) {
            throw new CustomArrayException("No CustomArray in Repository with id=" + arrayId);
        }

        return customArray;
    }

    public CustomArray set(int arrayId, CustomArray customArray) {

        CustomArray existingCustomArray = findCustomArrayWithId(arrayId);
        CustomArray newCustomArray;
        if (existingCustomArray == null) {
            newCustomArray = new CustomArray(arrayId, existingCustomArray.getArray());
            newCustomArray.attach(OBSERVER);
            newCustomArray.notifyObservers();
            items.add(newCustomArray);
        }else{
            items.remove(existingCustomArray);
            existingCustomArray.detach(OBSERVER);
            warehouse.remove(existingCustomArray.getId());

            newCustomArray = new CustomArray(arrayId, customArray.getArray());
            newCustomArray.attach(OBSERVER);
            newCustomArray.notifyObservers();
            items.add(newCustomArray);
        }

        return existingCustomArray;
    }

    public List<CustomArray> query(CustomArrayRepositorySpecification specification) {
        List<CustomArray> list = items.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }

    public List<CustomArray> query(Predicate<CustomArray> specification) {
        List<CustomArray> list = items.stream().filter(specification::test).collect(Collectors.toList());
        return list;
    }

    public void sort(Comparator<? super CustomArray> comparator){
        items.sort(comparator);
    }

    private CustomArray findCustomArrayWithId(int arrayId){
        CustomArray customArray = null;
        for (CustomArray el : items) {
            if (el.getId() == arrayId) {
                customArray = el;
            }
        }
        return customArray;
    }
}
