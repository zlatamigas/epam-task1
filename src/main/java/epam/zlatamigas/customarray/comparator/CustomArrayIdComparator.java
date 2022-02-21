package epam.zlatamigas.customarray.comparator;

import epam.zlatamigas.customarray.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getId() - o2.getId();
    }
}
