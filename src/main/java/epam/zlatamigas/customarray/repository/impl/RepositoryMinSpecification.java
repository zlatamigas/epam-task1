package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;

import java.util.OptionalInt;

public class RepositoryMinSpecification implements CustomArrayRepositorySpecification {

    private static final CustomArrayCounter COUNTER = new CustomArrayCounterImpl();

    private int valueCompareTo;
    private NumericSpecificationDegree degree;

    public RepositoryMinSpecification(int valueCompareTo, NumericSpecificationDegree degree) {
        this.valueCompareTo = valueCompareTo;
        this.degree = degree;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt optionalMin = COUNTER.minStream(customArray);
        int min;
        if (optionalMin.isPresent()) {
            min = optionalMin.getAsInt();
        } else {
            return false;
        }

        boolean result = switch (degree) {
            case NOT_EQUALS -> min != valueCompareTo;
            case GREATER -> min > valueCompareTo;
            case GREATER_OR_EQUALS -> min >= valueCompareTo;
            case EQUALS -> min == valueCompareTo;
            case LESS_OR_EQUALS -> min <= valueCompareTo;
            case LESS -> min < valueCompareTo;
        };

        return result;
    }
}
