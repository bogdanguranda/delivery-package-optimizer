package com.bogdanguranda.deliverypackageoptimizer.printer;

import com.bogdanguranda.deliverypackageoptimizer.model.Package;

public interface ResultPrinter {

    /**
     * Prints a resulted optimized package to the standard output.
     *
     * @param optimizedPackage an optimized package to print
     */
    void print(Package optimizedPackage);
}
