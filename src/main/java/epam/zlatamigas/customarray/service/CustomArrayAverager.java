package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

import java.util.OptionalDouble;

public interface CustomArrayAverager {
    OptionalDouble average(CustomArray customArray);

    OptionalDouble averageStream(CustomArray customArray);
}
