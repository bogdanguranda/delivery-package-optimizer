package com.bogdanguranda.deliverypackageoptimizer.parser;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.InvalidFileFormatException;
import com.bogdanguranda.deliverypackageoptimizer.model.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StandardFileParser implements FileParser {

    public List<UseCase> parse(String fileName) throws FileNotFoundException, InvalidFileFormatException {
        List<UseCase> useCases = new ArrayList<>();

        // I'm using try with resources, so the scanner is closed properly (scanner.close() is called in any case).
        try (Scanner scanner = new Scanner(getFile(fileName))) {
            while (scanner.hasNextLine()) {
                useCases.add(parseLine(scanner.nextLine()));
            }
        }

        if (useCases.size() == 0) {
            throw new InvalidFileFormatException();
        }

        return useCases;
    }

    private File getFile(String fileName) {
        return new File(System.getProperty("user.dir") + "/" + fileName);
    }

    private UseCase parseLine(String rawUseCase) throws InvalidFileFormatException {
        String[] limitAndItems = rawUseCase.split(" : ");
        if (limitAndItems.length != 2) {
            throw new InvalidFileFormatException();
        }

        try {
            Double limit = Double.valueOf(limitAndItems[0]);

            List<Item> items = new ArrayList<>();
            String[] rawItems = limitAndItems[1].split(" ");
            if (rawItems.length == 0) {
                throw new InvalidFileFormatException();
            }

            for (String rawItem : rawItems) {
                items.add(parseItem(rawItem));
            }

            return new UseCase(limit, items);
        } catch (NumberFormatException e) {
            throw new InvalidFileFormatException();
        }
    }

    private Item parseItem(String rawItem) throws InvalidFileFormatException {
        // The length should be minimum 2, because of the start and end parenthesis.
        if (rawItem.length() < 2) {
            throw new InvalidFileFormatException();
        }

        // Remove the start and end parenthesis.
        rawItem = rawItem.substring(1, rawItem.length() - 1);

        String[] itemData = rawItem.split(",");

        // The item should have an id, weight and cost, otherwise the format is wrong.
        if (itemData.length != 3) {
            throw new InvalidFileFormatException();
        }

        // Remove the EURO sign at the beginning of the cost.
        String rawCost = itemData[2].substring(1);

        return new Item(Integer.valueOf(itemData[0]), Double.valueOf(itemData[1]), Integer.valueOf(rawCost));
    }
}
