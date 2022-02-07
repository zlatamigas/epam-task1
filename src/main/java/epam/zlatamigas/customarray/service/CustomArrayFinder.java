package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;

public interface CustomArrayFinder {
    int findMin(CustomArray customArray) throws CustomArrayException;
    int findMinStream(CustomArray customArray) throws CustomArrayException;
    int findMax(CustomArray customArray) throws CustomArrayException;
    int findMaxStream(CustomArray customArray) throws CustomArrayException;
}
