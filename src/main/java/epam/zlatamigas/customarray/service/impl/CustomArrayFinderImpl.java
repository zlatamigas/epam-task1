package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayFinder;

import java.util.Arrays;
import java.util.OptionalInt;

public class CustomArrayFinderImpl implements CustomArrayFinder {

    @Override
    public OptionalInt findMin(CustomArray customArray) {

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
    public OptionalInt findMinStream(CustomArray customArray) {

        OptionalInt min = Arrays.stream(customArray.getArray()).min();

        return min;
    }

    @Override
    public OptionalInt findMax(CustomArray customArray) {

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
    public OptionalInt findMaxStream(CustomArray customArray) {

        OptionalInt max = Arrays.stream(customArray.getArray()).max();

        return max;
    }
}
