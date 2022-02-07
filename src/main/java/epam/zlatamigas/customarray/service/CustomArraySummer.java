package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;

public interface CustomArraySummer {
    int sum(CustomArray customArray) throws CustomArrayException;
    int sumStream(CustomArray customArray) throws CustomArrayException;
}
