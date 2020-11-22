package com.bogdanguranda.deliverypackageoptimizer.validator;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

import java.util.List;

public class DefaultUseCaseValidator implements UseCaseValidator {

    private static final Integer PACKAGE_WEIGHT_LIMIT = 100;
    private static final Integer ITEMS_LIMIT = 15;
    private static final Double ITEM_WEIGHT_LIMIT = 100.0;
    private static final Integer ITEM_COST_LIMIT = 100;

    @Override
    public void validate(List<UseCase> useCases) throws ConstraintViolation {
        String errorMessage = "";

        for (int i = 0; i < useCases.size(); i++) {
            String errors = validateUseCase(useCases.get(i));
            if (!errors.equals("")) {
                errorMessage += "Invalid use case at line " + (i + 1) + ":\n" + errors + "\n";
            }
        }

        if (!errorMessage.equals("")) {
            throw new ConstraintViolation("Constraints violations where found!\n\n" + errorMessage);
        }
    }

    private String validateUseCase(UseCase useCase) {
        String errorMessage = "";
        if (useCase.getWeightLimit() > PACKAGE_WEIGHT_LIMIT) {
            errorMessage += " - package weight is above the limit of " + PACKAGE_WEIGHT_LIMIT + "\n";
        }

        if (useCase.getAllItems().size() > ITEMS_LIMIT) {
            errorMessage += " - the number of items is above the limit of " + ITEMS_LIMIT + "\n";
        }

        for (Item item : useCase.getAllItems()) {
            errorMessage += validateItem(item);
        }

        return errorMessage;
    }

    private String validateItem(Item item) {
        String errorMessage = "";
        if (item.getWeight() > ITEM_WEIGHT_LIMIT) {
            errorMessage += "   - the item with id " + item.getId() + " has the weight above the limit of " + ITEM_WEIGHT_LIMIT + "\n";
        }

        if (item.getCost() > ITEM_COST_LIMIT) {
            errorMessage += "   - the item with id " + item.getId() + " has the cost above the limit of " + ITEM_COST_LIMIT + "\n";
        }

        return errorMessage;
    }
}
