package epam.zlatamigas.customarray.validator.impl;

import epam.zlatamigas.customarray.validator.CustomArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidatorImpl implements CustomArrayValidator {

    public static final String REGEX_ARRAY = "^([+-]?\\d+\\s+)*([+-]?\\d+)?$";

    @Override
    public boolean validate(String arrayStr) {

        Pattern p = Pattern.compile(REGEX_ARRAY);
        Matcher m = p.matcher(arrayStr);

        return m.matches();
    }
}
