package epam.zlatamigas.customarray.reader.impl;

import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.reader.CustomArrayReader;
import epam.zlatamigas.customarray.validator.CustomArrayValidator;
import epam.zlatamigas.customarray.validator.impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomArrayReaderImpl implements CustomArrayReader {

    private static final Logger logger = LogManager.getLogger();

    //Redo reading
    @Override
    public String readArrayStrFromFile(String filePath) throws CustomArrayException {

        try (var bufferedReader = new BufferedReader(new FileReader(filePath))) {

            CustomArrayValidator validator = CustomArrayValidatorImpl.getInstance();

            String str = bufferedReader.readLine();
            if (str == null)
                return "";

            do {
                if (validator.validate(str)) {
                    return str;
                }

                str = bufferedReader.readLine();
            } while (str != null);

        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomArrayException(e);
        }

        logger.error("No valid array found in " + filePath);
        throw new CustomArrayException("No valid array found in " + filePath);
    }

    //TODO
    @Override
    public String[] readAllArraysStrFromFile(String filePath) throws CustomArrayException {
        return new String[0];
    }
}
