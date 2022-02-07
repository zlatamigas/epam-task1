package epam.zlatamigas.customarray.creator;

import epam.zlatamigas.customarray.entity.CustomArray;

public class CustomArrayCreator {

    public CustomArray createCustomArray(int... array){
        return new CustomArray(array);
    }
}
