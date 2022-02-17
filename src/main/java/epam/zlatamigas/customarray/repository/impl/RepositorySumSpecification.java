package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;

import java.util.OptionalInt;

public class RepositorySumSpecification implements CustomArrayRepositorySpecification {

    private static final CustomArrayCounter COUNTER = new CustomArrayCounterImpl();

    private int valueCompareTo;
    private NumericSpecificationDegree degree;

    public RepositorySumSpecification(int valueCompareTo, NumericSpecificationDegree degree) {
        this.valueCompareTo = valueCompareTo;
        this.degree = degree;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt optionalSum = COUNTER.sumStream(customArray);
        int sum = optionalSum.isPresent() ? optionalSum.getAsInt() : 0;

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
