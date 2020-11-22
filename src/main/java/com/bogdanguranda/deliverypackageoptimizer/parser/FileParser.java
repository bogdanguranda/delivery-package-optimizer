package com.bogdanguranda.deliverypackageoptimizer.parser;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.InvalidFileFormatException;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileParser {

    /**
     * Reads delivery package use cases from a given file.
     *
     * @param fileName the name of the file containing the use cases
     * @return a list of use cases
     */
    List<UseCase> parse(String fileName) throws FileNotFoundException, InvalidFileFormatException;
}
