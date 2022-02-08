package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArraySorter;

public class CustomArraySorterImpl implements CustomArraySorter {

    @Override
    public void bubbleSort(CustomArray customArray) {

        int[] array = customArray.getArray();
        int n = array.length;

        boolean switched;

        do {
            switched = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    switched = true;
                }
            }
            n--;

        } while (n > 0 && switched);

        customArray.setArray(array);
    }

    @Override
    public void selectionSort(CustomArray customArray) {

        int[] array = customArray.getArray();

        int pos;
        int temp;

        for (int i = 0; i < array.length; i++) {

            pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[pos]) {
                    pos = j;
                }
            }

            temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
        }

        customArray.setArray(array);
    }

    @Override
    public void mergeSort(CustomArray customArray) {

        int[] array = customArray.getArray();
        mergeSort(array, 0, array.length - 1);

        customArray.setArray(array);
    }

    private void merge(int[] array, int left, int middle, int right) {

        int low = middle - left + 1;
        int high = right - middle;

        int[] leftArr = new int[low];
        int[] rightArr = new int[high];

        int i = 0, j = 0;

        for (i = 0; i < low; i++) {
            leftArr[i] = array[left + i];
        }
        for (j = 0; j < high; j++) {
            rightArr[j] = array[middle + 1 + j];
        }


        int k = left;
        i = 0;
        j = 0;

        while (i < low && j < high) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < low) {
            array[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < high) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }
}
