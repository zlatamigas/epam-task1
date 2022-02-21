package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;

public class RepositorySizeSpecification implements CustomArrayRepositorySpecification {

    private int valueCompareTo;
    private NumericSpecificationDegree degree;

    public RepositorySizeSpecification(int valueCompareTo, NumericSpecificationDegree degree) {
        this.valueCompareTo = valueCompareTo;
        this.degree = degree;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        int sum = customArray.getSize();

        boolean result = switch (degree) {
            case NOT_EQUALS -> sum != valueCompareTo;
            case GREATER -> sum > valueCompareTo;
            case GREATER_OR_EQUALS -> sum >= valueCompareTo;
            case EQUALS -> sum == valueCompareTo;
            case LESS_OR_EQUALS -> sum <= valueCompareTo;
            case LESS -> sum < valueCompareTo;
            default -> false;
        };

        return result;
    }
}
