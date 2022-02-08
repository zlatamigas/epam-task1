package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

import java.util.OptionalInt;

public interface CustomArrayFinder {

    OptionalInt findMin(CustomArray customArray);

    OptionalInt findMinStream(CustomArray customArray);

    OptionalInt findMax(CustomArray customArray);

    OptionalInt findMaxStream(CustomArray customArray);
}
