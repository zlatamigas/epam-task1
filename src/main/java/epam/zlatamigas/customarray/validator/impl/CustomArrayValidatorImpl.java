package epam.zlatamigas.customarray.validator.impl;

import epam.zlatamigas.customarray.validator.CustomArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidatorImpl implements CustomArrayValidator {

    public static final String REGEX_ARRAY = "^\\s*(([+-]?\\d+\\s+)*([+-]?\\d+)?)\\s*$";

    private static CustomArrayValidatorImpl instance;

    private CustomArrayValidatorImpl() {
    }

    public static CustomArrayValidatorImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayValidatorImpl();
        }
        return instance;
    }


    @Override
    public boolean validate(String arrayStr) {

        Pattern pattern = Pattern.compile(REGEX_ARRAY);
        Matcher matcher = pattern.matcher(arrayStr);

        return matcher.matches();
    }
}
