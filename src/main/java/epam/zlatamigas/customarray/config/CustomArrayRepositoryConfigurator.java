package epam.zlatamigas.customarray.config;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.entity.CustomArrayWarehouse;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.observer.CustomArrayObserver;
import epam.zlatamigas.customarray.observer.impl.CustomArrayObserverImpl;
import epam.zlatamigas.customarray.repository.CustomArrayRepository;

import java.util.List;

public class CustomArrayRepositoryConfigurator {

    private static CustomArrayObserver observer = new CustomArrayObserverImpl();
    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    private static CustomArrayRepository repository = CustomArrayRepository.getInstance();

    public boolean addToRepository(CustomArray customArray) {
        boolean result = repository.add(customArray);
        if (result) {
            customArray.attach(observer);
            customArray.notifyObservers();
        }
        return result;
    }

    public int addAllToRepository(List<? extends CustomArray> customArrays) {
        boolean result;
        int addNumber = 0;

        for (CustomArray customArray : customArrays) {
            result = repository.add(customArray);
            if (result) {
                customArray.attach(observer);
                customArray.notifyObservers();
                addNumber++;
            }
        }

        return addNumber;
    }

    public boolean removeFromRepository(int arrayId) {

        boolean result;
        CustomArray customArray = null;

        try {
            customArray = repository.get(arrayId);
            result = repository.remove(customArray);
            if (result) {
                customArray.detach(observer);
                warehouse.remove(customArray.getId());
            }
        } catch (CustomArrayException e) {
            result = false;
        }

        return result;
    }

    public boolean removeFromRepository(CustomArray customArray) {
        boolean result = repository.remove(customArray);
        if (result) {
            customArray.detach(observer);
            warehouse.remove(customArray.getId());
        }
        return result;
    }

    public int removeAllFromRepository(List<? extends CustomArray> customArrays) {
        boolean result;
        int removedNumber = 0;

        for (CustomArray customArray : customArrays) {
            result = repository.add(customArray);
            if (result) {
                customArray.detach(observer);
                warehouse.remove(customArray.getId());
                removedNumber++;
            }
        }

        return removedNumber;
    }
}
