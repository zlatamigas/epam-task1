package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

public interface CustomArrayCounter {
    long countPositive(CustomArray customArray);
    long countPositiveStream(CustomArray customArray);
    long countNegative(CustomArray customArray);
    long countNegativeStream(CustomArray customArray);
}
