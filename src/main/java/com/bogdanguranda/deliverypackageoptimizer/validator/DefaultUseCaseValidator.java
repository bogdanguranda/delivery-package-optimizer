package com.bogdanguranda.deliverypackageoptimizer.constraints;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

import java.util.List;

public class DefaultUseCaseValidator implements UseCaseValidator {

    @Override
    public void validate(List<UseCase> useCases) throws ConstraintViolation {
        // TODO: validate uses cases and throw error if one is invalid
    }
}
