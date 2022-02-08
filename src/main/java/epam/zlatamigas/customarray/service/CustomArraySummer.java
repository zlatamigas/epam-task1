package epam.zlatamigas.customarray.service;

import epam.zlatamigas.customarray.entity.CustomArray;

import java.util.OptionalInt;

public interface CustomArraySummer {
    OptionalInt sum(CustomArray customArray);

    OptionalInt sumStream(CustomArray customArray);
}
