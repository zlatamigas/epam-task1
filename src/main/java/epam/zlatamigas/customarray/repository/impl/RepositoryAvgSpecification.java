package epam.zlatamigas.customarray.repository.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.repository.CustomArrayRepositorySpecification;
import epam.zlatamigas.customarray.repository.NumericSpecificationDegree;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class RepositoryAvgSpecification implements CustomArrayRepositorySpecification {

    private static final CustomArrayCounter COUNTER = new CustomArrayCounterImpl();

    private double valueCompareTo;
    private NumericSpecificationDegree degree;

    public RepositoryAvgSpecification(double valueCompareTo, NumericSpecificationDegree degree) {
        this.valueCompareTo = valueCompareTo;
        this.degree = degree;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        OptionalDouble optionalAvg = COUNTER.averageStream(customArray);
        double avg;
        if (optionalAvg.isPresent()) {
            avg = optionalAvg.getAsDouble();
        } else {
            return false;
        }

        boolean result = switch (degree) {
            case NOT_EQUALS -> avg != valueCompareTo;
            case GREATER -> avg > valueCompareTo;
            case GREATER_OR_EQUALS -> avg >= valueCompareTo;
            case EQUALS -> avg == valueCompareTo;
            case LESS_OR_EQUALS -> avg <= valueCompareTo;
            case LESS -> avg < valueCompareTo;
        };

        return result;
    }
}
