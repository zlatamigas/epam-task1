package epam.zlatamigas.customarray.config;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.entity.CustomArrayWarehouse;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.observer.CustomArrayObserver;
import epam.zlatamigas.customarray.observer.impl.CustomArrayObserverImpl;
import epam.zlatamigas.customarray.repository.CustomArrayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomArrayRepositoryConfigurator {

    private static final Logger logger = LogManager.getLogger();

    private static CustomArrayObserver observer = new CustomArrayObserverImpl();
    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
    private static CustomArrayRepository repository = CustomArrayRepository.getInstance();

    public boolean addToRepository(CustomArray customArray) {
        boolean result = repository.add(customArray);
        if (result) {
            customArray.attach(observer);
            customArray.notifyObservers();

            logger.debug("CustomArray #" + customArray.getId() + " registered in repository.");
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

        logger.debug(addNumber + " CustomArrays registered in repository.");

        return addNumber;
    }

    public boolean removeFromRepository(int arrayId) {

        boolean result;

        try {
            CustomArray customArray = repository.get(arrayId);
            result = repository.remove(customArray);
            if (result) {
                customArray.detach(observer);
                warehouse.remove(customArray.getId());

                logger.debug("CustomArray #" + arrayId + " removed from repository.");
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

            logger.debug("CustomArray #" + customArray.getId() + " removed from repository.");
        }
        return result;
    }

    public int removeAllFromRepository(List<? extends CustomArray> customArrays) {
        boolean result;
        int removedNumber = 0;

        for (CustomArray customArray : customArrays) {
            result = repository.remove(customArray);
            if (result) {
                customArray.detach(observer);
                warehouse.remove(customArray.getId());
                removedNumber++;
            }
        }

        logger.debug(removedNumber + " CustomArrays removed from repository.");

        return removedNumber;
    }

    public int clearRepository() {
        List<CustomArray> items = repository.getItems();
        int removedNumber = removeAllFromRepository(items);

        logger.debug("Repository is cleared.");

        return removedNumber;
    }
}
