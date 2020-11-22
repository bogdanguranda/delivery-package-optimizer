package com.bogdanguranda.deliverypackageoptimizer.parser;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.InvalidFileFormatException;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileParser {
    List<UseCase> parse(String fileName) throws FileNotFoundException, InvalidFileFormatException;
}
