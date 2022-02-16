package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;

import java.util.OptionalInt;

public class RepositoryMaxSpecification implements CustomArrayRepositorySpecification {

    private static final CustomArrayCounter COUNTER = new CustomArrayCounterImpl();

    private int valueCompareTo;
    private NumericSpecificationDegree degree;

    public RepositoryMaxSpecification(int valueCompareTo, NumericSpecificationDegree degree) {
        this.valueCompareTo = valueCompareTo;
        this.degree = degree;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalInt optionalMax = COUNTER.maxStream(customArray);
        int max;
        if (optionalMax.isPresent()) {
            max = optionalMax.getAsInt();
        } else {
            return false;
        }

        boolean result = switch (degree) {
            case NOT_EQUALS -> max != valueCompareTo;
            case GREATER -> max > valueCompareTo;
            case GREATER_OR_EQUALS -> max >= valueCompareTo;
            case EQUALS -> max == valueCompareTo;
            case LESS_OR_EQUALS -> max <= valueCompareTo;
            case LESS -> max < valueCompareTo;
        };

        return result;
    }
}
