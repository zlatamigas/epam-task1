package epam.zlatamigas.customarray.reader;

import epam.zlatamigas.customarray.exception.CustomArrayException;

public interface CustomArrayReader {

    String readArrayStrFromFile(String filePath) throws CustomArrayException;

    String[] readAllArraysStrFromFile(String filePath) throws CustomArrayException;
}
