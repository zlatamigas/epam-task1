package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArrayFinder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalInt;

public class CustomArrayFinderImpl implements CustomArrayFinder {

    private static final Logger logger = LogManager.getLogger();

    private static final String EMPTY_ARRAY_EXCEPTION = "Empty CustomArray";

    @Override
    public int findMin(CustomArray customArray) throws CustomArrayException {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }

        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }

        return min;
    }

    @Override
    public int findMinStream(CustomArray customArray) throws CustomArrayException {

        OptionalInt min = Arrays.stream(customArray.getArray()).min();

        if (min.isPresent()) {
            return min.getAsInt();
        } else {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }
    }

    @Override
    public int findMax(CustomArray customArray) throws CustomArrayException {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }

        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    @Override
    public int findMaxStream(CustomArray customArray) throws CustomArrayException {

        OptionalInt max = Arrays.stream(customArray.getArray()).max();

        if (max.isPresent()) {
            return max.getAsInt();
        } else {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }
    }
}
