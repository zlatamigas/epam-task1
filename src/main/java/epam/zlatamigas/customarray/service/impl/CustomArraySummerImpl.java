package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArraySummer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArraySummerImpl implements CustomArraySummer {

    private static final Logger logger = LogManager.getLogger();

    private static final String EMPTY_ARRAY_EXCEPTION = "Empty CustomArray";

    @Override
    public int sum(CustomArray customArray) throws CustomArrayException {

        int sum = 0;

        int[] array = customArray.getArray();
        if (array.length == 0) {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }

        for (int element : array) {
            sum += element;
        }

        return sum;
    }

    @Override
    public int sumStream(CustomArray customArray) throws CustomArrayException {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }

        return Arrays.stream(array).sum();
    }
}
