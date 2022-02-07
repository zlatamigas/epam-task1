package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;

public interface CustomArrayAverager {
    double average(CustomArray customArray) throws CustomArrayException;
    double averageStream(CustomArray customArray) throws CustomArrayException;
}
