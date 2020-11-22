package com.bogdanguranda.deliverypackageoptimizer.constraints;

import com.bogdanguranda.deliverypackageoptimizer.exceptions.ConstraintViolation;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

import java.util.List;

public interface UseCaseValidator {
    void validate(List<UseCase> useCases) throws ConstraintViolation;
}
