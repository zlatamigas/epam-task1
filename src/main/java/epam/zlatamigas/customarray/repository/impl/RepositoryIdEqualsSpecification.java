package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;

public class RepositoryIdEqualsSpecification implements CustomArrayRepositorySpecification {

    private int id;

    public RepositoryIdEqualsSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        int id = customArray.getId();
        return this.id == id;
    }
}
