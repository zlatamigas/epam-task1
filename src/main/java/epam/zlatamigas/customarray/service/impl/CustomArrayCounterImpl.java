package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArrayCounterImpl implements CustomArrayCounter {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public long countPositive(CustomArray customArray) {

        long positiveCount = 0;

        int[] array = customArray.getArray();

        for (int element : array) {
            if (element > 0) {
                positiveCount++;
            }
        }

        return positiveCount;
    }

    @Override
    public long countPositiveStream(CustomArray customArray) {

        int[] array = customArray.getArray();
        long positiveCount = Arrays.stream(array).filter(element -> element > 0).count();

        return positiveCount;
    }

    @Override
    public long countNegative(CustomArray customArray) {

        long negativeCount = 0;

        int[] array = customArray.getArray();

        for (int element : array) {
            if (element < 0) {
                negativeCount++;
            }
        }

        return negativeCount;
    }

    @Override
    public long countNegativeStream(CustomArray customArray) {

        int[] array = customArray.getArray();
        long negativeCount = Arrays.stream(array).filter(element -> element < 0).count();

        return negativeCount;
    }
}
