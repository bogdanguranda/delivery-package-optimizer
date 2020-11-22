package com.bogdanguranda.deliverypackageoptimizer.optimizer;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DefaultPackageOptimizer implements PackageOptimizer {

    private Stack<Item> bestFit;
    private double weightLimit;

    @Override
    public Package optimize(UseCase useCase) {
        if (useCase.getAllItems().size() == 0) {
            return null; // no solution can be found
        }

        bestFit = new Stack<>();
        weightLimit = useCase.getWeightLimit();

        findBestCombinationRecursively(useCase.getAllItems(), 0, new Stack<>());

        if (bestFit.isEmpty()) {
            return null; // no solution was found
        }

        bestFit.sort(Comparator.comparing(Item::getId));
        return new Package(useCase.getWeightLimit(), bestFit);
    }

    private void findBestCombinationRecursively(List<Item> allItems, int start, Stack<Item> combination) {
        if (isValidCombination(combination, weightLimit)) {
            if (bestFit.isEmpty()) {
                bestFit.addAll(combination);
            } else {
                if (isNewCombinationBetter(bestFit, combination)) {
                    bestFit.clear();
                    bestFit.addAll(combination);
                }
            }
        }

        for (int i = start; i < allItems.size(); i++) {
            combination.push(allItems.get(i));
            findBestCombinationRecursively(allItems, i + 1, combination);
            combination.pop();
        }
    }

    private boolean isValidCombination(Stack<Item> items, double weightLimit) {
        return totalWeight(items) <= weightLimit;
    }

    private boolean isNewCombinationBetter(Stack<Item> current, Stack<Item> attempt) {
        double currentTotalCost = totalCost(current);
        double attemptTotalCost = totalCost(attempt);
        if (attemptTotalCost > currentTotalCost) {
            return true;
        } else if (currentTotalCost > attemptTotalCost) {
            return false;
        } else { // when the cost is equal, then we take the lighter one
            return isNewCombinationLighter(current, attempt);
        }
    }

    private boolean isNewCombinationLighter(Stack<Item> current, Stack<Item> attempt) {
        return totalWeight(attempt) < totalWeight(current);
    }

    private double totalWeight(Stack<Item> items) {
        double totalWeight = 0.0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    private double totalCost(Stack<Item> items) {
        int totalCost = 0;
        for (Item item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }
}
