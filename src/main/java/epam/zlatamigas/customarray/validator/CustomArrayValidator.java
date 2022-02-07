package epam.zlatamigas.customarray.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidator {

    public static final String REGEX_ARRAY = "^([+-]?\\d+\\s+)*([+-]?\\d+)?$";

    public static boolean validate(String arrayStr) {

        Pattern p = Pattern.compile(REGEX_ARRAY);
        Matcher m = p.matcher(arrayStr);

        return m.matches();
    }
}
