package epam.zlatamigas.customarray.service.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.service.CustomArrayChanger;

public class CustomArrayChangerImpl implements CustomArrayChanger {

    @Override
    public void changeSign(CustomArray customArray) {

        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }
        customArray.setArray(array);
    }
}
