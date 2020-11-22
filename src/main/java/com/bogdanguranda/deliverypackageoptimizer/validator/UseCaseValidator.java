package com.bogdanguranda.deliverypackageoptimizer.validator;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

import java.util.List;

public interface UseCaseValidator {

    /**
     * Validates a list of use cases based on the following constraints:
     * <p>
     * 1. The maximum weight that a package can hold must be <= 100.
     * 2. There may be up to 15 items you can to choose from.
     * 3. The maximum weight of an item should be <= 100.
     * 4. The maximum cost of an item should be <= €100.
     *
     * @param useCases a list of use cases to validate of constraints
     * @throws ConstraintViolation exception if any of the constraints are violated and mentions all that where
     */
    void validate(List<UseCase> useCases) throws ConstraintViolation;
}
