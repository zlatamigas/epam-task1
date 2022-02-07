package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.service.CustomArrayAverager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;

public class CustomArrayAveragerImpl implements CustomArrayAverager {

    private static final Logger logger = LogManager.getLogger();

    private static final String EMPTY_ARRAY_EXCEPTION = "Empty CustomArray";

    @Override
    public double average(CustomArray customArray) throws CustomArrayException {

        double sum = 0;

        int[] array = customArray.getArray();
        if (array.length == 0) {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }

        for (int element : array) {
            sum += element;
        }

        return sum / array.length;
    }

    @Override
    public double averageStream(CustomArray customArray) throws CustomArrayException {

        OptionalDouble avg = Arrays.stream(customArray.getArray()).average();

        if (avg.isPresent()) {
            return avg.getAsDouble();
        } else {
            logger.error(EMPTY_ARRAY_EXCEPTION);
            throw new CustomArrayException(EMPTY_ARRAY_EXCEPTION);
        }
    }
}
