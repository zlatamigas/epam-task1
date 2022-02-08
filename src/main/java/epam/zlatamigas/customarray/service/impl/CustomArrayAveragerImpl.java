package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayAverager;

import java.util.Arrays;
import java.util.OptionalDouble;

public class CustomArrayAveragerImpl implements CustomArrayAverager {

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
}
