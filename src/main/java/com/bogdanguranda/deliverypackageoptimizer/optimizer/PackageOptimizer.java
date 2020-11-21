package com.bogdanguranda.deliverypackageoptimizer.optimizer;

import com.bogdanguranda.deliverypackageoptimizer.parser.TestCase;

public interface PackageOptimizer {
    Package optimize(TestCase testCase);
}
