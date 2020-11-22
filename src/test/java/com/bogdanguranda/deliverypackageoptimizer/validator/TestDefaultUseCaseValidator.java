package com.bogdanguranda.deliverypackageoptimizer.validator;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDefaultUseCaseValidator {

    private UseCaseValidator useCaseValidator = new DefaultUseCaseValidator();

    /**
     * Test that when there are no use cases given there's no violation thrown.
     */
    @Test
    public void testWhenNoUseCasesNoViolationIsThrown() throws ConstraintViolation {
        useCaseValidator.validate(new ArrayList<UseCase>());
    }

    /**
     * Test that when the maximum weight of the package is more the 100 a violation exception is thrown.
     */
    @Test(expected = ConstraintViolation.class)
    public void testWhenPackageWeightIsAbove100ThenViolationIsThrown() throws ConstraintViolation {
        List<UseCase> useCases = new ArrayList<>();
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(1, 2.0, 30));
        useCases.add(new UseCase(101.0, items1));
        useCaseValidator.validate(useCases);
    }

    /**
     * Test that when there are more than 15 items to choose from a violation exception is thrown.
     */
    @Test(expected = ConstraintViolation.class)
    public void testWhenMoreThan15ItemsThenViolationIsThrown() throws ConstraintViolation {
        List<UseCase> useCases = new ArrayList<>();
        List<Item> items1 = Arrays.asList(
                new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3),
                new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3),
                new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3), new Item(1, 2.0, 3),
                new Item(1, 2.0, 3));
        System.out.println(items1.size());
        useCases.add(new UseCase(80.0, items1));
        useCaseValidator.validate(useCases);
    }

    /**
     * Test that when the weight of an item is more than 100 a violation exception is thrown.
     */
    @Test(expected = ConstraintViolation.class)
    public void testWhenItemWeightIsAbove100ThenViolationIsThrown() throws ConstraintViolation {
        List<UseCase> useCases = new ArrayList<>();
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(1, 100.01, 30));
        useCases.add(new UseCase(80.0, items1));
        useCaseValidator.validate(useCases);
    }

    /**
     * Test that when the cost of an item is more than €100 a violation exception is thrown.
     */
    @Test(expected = ConstraintViolation.class)
    public void testWhenItemCostIsAbove100ThenViolationIsThrown() throws ConstraintViolation {
        List<UseCase> useCases = new ArrayList<>();
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(1, 2.0, 101));
        useCases.add(new UseCase(80.0, items1));
        useCaseValidator.validate(useCases);
    }
}
