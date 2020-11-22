package com.bogdanguranda.deliverypackageoptimizer.printer;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;

import java.util.List;

public class DefaultResultPrinter implements ResultPrinter {

    /**
     * Prints the resulted optimized package to the standard output.
     *
     * @param resultPackage the optimized package
     */
    @Override
    public void print(Package resultPackage) {
        if (resultPackage == null || resultPackage.getItems().size() == 0) {
            System.out.println("-");
        } else {
            List<Item> items = resultPackage.getItems();
            for (int i = 0; i < items.size() - 1; i++) {
                System.out.print(items.get(i).getId() + ", ");
            }
            System.out.println(items.get(items.size() - 1).getId());
        }
    }
}
