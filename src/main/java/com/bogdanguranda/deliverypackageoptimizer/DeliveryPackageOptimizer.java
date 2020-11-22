package com.bogdanguranda.deliverypackageoptimizer;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.exceptions.InvalidFileFormatException;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import com.bogdanguranda.deliverypackageoptimizer.optimizer.DefaultPackageOptimizer;
import com.bogdanguranda.deliverypackageoptimizer.optimizer.PackageOptimizer;
import com.bogdanguranda.deliverypackageoptimizer.parser.FileParser;
import com.bogdanguranda.deliverypackageoptimizer.parser.StandardFileParser;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;
import com.bogdanguranda.deliverypackageoptimizer.printer.ResultPrinter;
import com.bogdanguranda.deliverypackageoptimizer.printer.StandardOutputResultPrinter;
import com.bogdanguranda.deliverypackageoptimizer.validator.DefaultUseCaseValidator;
import com.bogdanguranda.deliverypackageoptimizer.validator.UseCaseValidator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DeliveryPackageOptimizer {

    private static FileParser fileParser = new StandardFileParser();
    private static UseCaseValidator validator = new DefaultUseCaseValidator();
    private static PackageOptimizer optimizer = new DefaultPackageOptimizer();
    private static ResultPrinter printer = new StandardOutputResultPrinter();

    private static List<UseCase> useCases;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("Error: no argument given.\nThe program needs 1 argument, i.e. the name of the file to read from.");
            return;
        }
        String fileName = args[0];

        Scanner scanner = new Scanner(System.in);
        while (!loadFile(fileName) || !validateUseCases()) {
            // Was unable to load/parse the file or is violating constraints, prompt the user for a file name and try loading again.
            System.out.print("\nPlease enter a file name that is formatted right and doesn't violate constraints, and hit enter to load it: ");
            fileName = scanner.nextLine();
        }

        for (UseCase useCase : useCases) {
            Package optimizedPackage = optimizer.optimize(useCase);
            printer.print(optimizedPackage);
        }
    }

    private static boolean loadFile(String filename) {
        try {
            useCases = fileParser.parse(filename);
        } catch (FileNotFoundException e) {
            System.out.print("Error: the file name given was not found.");
            return false;
        } catch (InvalidFileFormatException e) {
            System.out.print("Error: the file given has invalid format.");
            return false;
        }
        return true;
    }

    private static boolean validateUseCases() {
        try {
            validator.validate(useCases);
        } catch (ConstraintViolation constraintViolation) {
            System.out.println("Error: the file has cases that are violating constraints.");
            System.out.print(constraintViolation.getMessage());
            return false;
        }
        return true;
    }
}
