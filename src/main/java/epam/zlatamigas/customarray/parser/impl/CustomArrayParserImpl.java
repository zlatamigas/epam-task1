package epam.zlatamigas.customarray.parser.impl;

import epam.zlatamigas.customarray.parser.CustomArrayParser;

public class CustomArrayParserImpl implements CustomArrayParser {

    private static final String DELIMITER = "\\s";

    @Override
    public int[] parseStrToIntArray(String arrayStr) {

        if (arrayStr.isBlank()) {
            return new int[0];
        }

        String[] numbersStr = arrayStr.split(DELIMITER);
        int[] numbers = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        return numbers;
    }
}
