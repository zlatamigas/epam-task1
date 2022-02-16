package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

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


    @Override
    public OptionalDouble average(CustomArray customArray) {

        double sum = 0;

        int[] array = customArray.getArray();
        if (array.length == 0) {
            return OptionalDouble.empty();
        }

        for (int element : array) {
            sum += element;
        }

        double avg = sum / array.length;

        return OptionalDouble.of(avg);
    }

    @Override
    public OptionalDouble averageStream(CustomArray customArray) {

        OptionalDouble avg = Arrays.stream(customArray.getArray()).average();

        return avg;
    }



    @Override
    public OptionalInt min(CustomArray customArray) {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }

        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }

        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt minStream(CustomArray customArray) {

        OptionalInt min = Arrays.stream(customArray.getArray()).min();

        return min;
    }

    @Override
    public OptionalInt max(CustomArray customArray) {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }

        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }

        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt maxStream(CustomArray customArray) {

        OptionalInt max = Arrays.stream(customArray.getArray()).max();

        return max;
    }


    @Override
    public OptionalInt sum(CustomArray customArray) {

        int sum = 0;

        int[] array = customArray.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }

        for (int element : array) {
            sum += element;
        }

        return OptionalInt.of(sum);
    }

    @Override
    public OptionalInt sumStream(CustomArray customArray) {

        int[] array = customArray.getArray();
        if (array.length == 0) {
            return OptionalInt.empty();
        }

        int sum = Arrays.stream(array).sum();

        return OptionalInt.of(sum);
    }

}
