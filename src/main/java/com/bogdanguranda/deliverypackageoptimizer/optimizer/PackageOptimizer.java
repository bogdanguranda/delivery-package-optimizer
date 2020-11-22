package com.bogdanguranda.deliverypackageoptimizer.optimizer;

import com.bogdanguranda.deliverypackageoptimizer.model.Package;
import com.bogdanguranda.deliverypackageoptimizer.parser.UseCase;

public interface PackageOptimizer {

    /**
     * Given a use case with a package weight limit and list of items, finds the best fit of items into the package
     * so that the most value is added (cost).
     * <p>
     * In case that 2 solutions are found with the same value, the one with the lower weight is chosen, if that
     * is equal as well, the first one is chosen.
     *
     * @param useCase the use case containing the weight limit and list of items
     * @return the optimized package with it's weight limit and items or null if no solution is found
     */
    Package optimize(UseCase useCase);
}
