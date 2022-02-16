package epam.zlatamigas.customarray.observer.impl;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.entity.CustomArrayParameters;
import epam.zlatamigas.customarray.entity.CustomArrayWarehouse;
import epam.zlatamigas.customarray.observer.CustomArrayEvent;
import epam.zlatamigas.customarray.observer.CustomArrayObserver;
import epam.zlatamigas.customarray.service.CustomArrayCounter;
import epam.zlatamigas.customarray.service.impl.CustomArrayCounterImpl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    private static CustomArrayCounter counter = new CustomArrayCounterImpl();
    private static CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();

    @Override
    public void parameterChanged(CustomArrayEvent event) {

        CustomArray array = event.getSource();

        OptionalInt max = counter.maxStream(array);
        OptionalInt min = counter.minStream(array);
        OptionalInt sum = counter.sumStream(array);
        OptionalDouble average = counter.averageStream(array);

        CustomArrayParameters parameters = warehouse.get(array.getId());
        if(parameters==null){
            parameters = new CustomArrayParameters(max, min, sum, average);
            warehouse.put(array.getId(), parameters);
        }

        parameters.setMax(max);
        parameters.setMin(min);
        parameters.setSum(sum);
        parameters.setAverage(average);
    }
}
