package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArraySummer;

import java.util.Arrays;
import java.util.OptionalInt;

public class CustomArraySummerImpl implements CustomArraySummer {

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
