package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

public interface CustomArraySorter {

    void bubbleSort(CustomArray customArray);

    void mergeSort(CustomArray customArray);

    void selectionSort(CustomArray customArray);
}
