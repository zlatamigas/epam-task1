package epam.zlatamigas.customarray.reader.impl;

import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.reader.CustomArrayReader;
import epam.zlatamigas.customarray.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomArrayReaderImpl implements CustomArrayReader {

    private static final Logger logger = LogManager.getLogger();

    private static final String NO_ARRAY_EXCEPTION_MESSAGE = "No valid array found in ";

    @Override
    public String readArrayStrFromFile(String filePath) throws CustomArrayException {

        try (var bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String str = bufferedReader.readLine();
            if (str == null)
                return "";

            do {
                if (CustomArrayValidator.validate(str)) {
                    return str;
                }

                str = bufferedReader.readLine();
            } while (str != null);

        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomArrayException(e);
        }

        logger.error(NO_ARRAY_EXCEPTION_MESSAGE + filePath);
        throw new CustomArrayException(NO_ARRAY_EXCEPTION_MESSAGE + filePath);
    }
}
