package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;

public class RepositoryIdIntervalSpecification implements CustomArrayRepositorySpecification {

    private int lowerBoarder;
    private int upperBoarder;

    public RepositoryIdIntervalSpecification(int lowerBoarder, int upperBoarder) {

        if (lowerBoarder < upperBoarder) {
            this.lowerBoarder = lowerBoarder;
            this.upperBoarder = upperBoarder;
        } else {
            this.lowerBoarder = upperBoarder;
            this.upperBoarder = lowerBoarder;
        }
    }

    @Override
    public boolean specify(CustomArray customArray) {
        int id = customArray.getId();

        return id >= lowerBoarder && id <= upperBoarder;
    }
}
