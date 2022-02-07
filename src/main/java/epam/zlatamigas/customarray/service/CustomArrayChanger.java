package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

public interface CustomArrayChanger {
    void changeSign(CustomArray customArray);
    void changeSignStream(CustomArray customArray);
}
