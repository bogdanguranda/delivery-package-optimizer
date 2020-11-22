package com.bogdanguranda.deliverypackageoptimizer.optimizer;

import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

public interface PackageOptimizer {
    Package optimize(UseCase useCase);
}
