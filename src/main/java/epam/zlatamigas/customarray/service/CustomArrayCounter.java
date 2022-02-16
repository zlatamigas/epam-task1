package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface CustomArrayCounter {

    long countPositive(CustomArray customArray);

    long countPositiveStream(CustomArray customArray);

    long countNegative(CustomArray customArray);

    long countNegativeStream(CustomArray customArray);


    OptionalDouble average(CustomArray customArray);

    OptionalDouble averageStream(CustomArray customArray);


    OptionalInt min(CustomArray customArray);

    OptionalInt minStream(CustomArray customArray);

    OptionalInt max(CustomArray customArray);

    OptionalInt maxStream(CustomArray customArray);


    OptionalInt sum(CustomArray customArray);

    OptionalInt sumStream(CustomArray customArray);

}
