package epam.zlatamigas.customarray.reader.impl;

import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.reader.CustomArrayReader;
import epam.zlatamigas.customarray.validator.CustomArrayValidator;
import epam.zlatamigas.customarray.validator.impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CustomArrayReaderImpl implements CustomArrayReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public String readArrayStrFromFile(String filePath) throws CustomArrayException {

        File file = new File(filePath);
        if (file.exists() && file.length() == 0) {
            return "";
        }

        logger.debug("Reader got access to file: " + filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            CustomArrayValidator validator = CustomArrayValidatorImpl.getInstance();

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (validator.validate(str)) {
                    return str;
                }
            }

            logger.warn("No valid array found in " + filePath);

        } catch (IOException e) {
            throw new CustomArrayException(e);
        }

        throw new CustomArrayException("No valid array found in " + filePath);
    }

    @Override
    public String[] readAllArraysStrFromFile(String filePath) throws CustomArrayException {

        File file = new File(filePath);
        if (file.exists() && file.length() == 0) {
            return new String[0];
        }

        logger.debug("Reader got access to file: " + filePath);

        String[] arrayStrs;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            CustomArrayValidator validator = CustomArrayValidatorImpl.getInstance();
            arrayStrs = bufferedReader.lines().filter(validator::validate).toArray(String[]::new);

        } catch (IOException e) {
            throw new CustomArrayException(e);
        }

        if (arrayStrs.length != 0) {
            logger.debug("Number of valid arrays read: " + arrayStrs.length);
            return arrayStrs;
        } else {
            logger.warn("No valid arrays found in " + filePath);
            throw new CustomArrayException("No valid array found in " + filePath);
        }
    }
}
