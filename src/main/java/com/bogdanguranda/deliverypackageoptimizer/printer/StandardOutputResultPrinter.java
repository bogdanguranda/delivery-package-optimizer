package com.bogdanguranda.deliverypackageoptimizer.printer;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;
import com.bogdanguranda.deliverypackageoptimizer.model.Package;

import java.util.List;

public class StandardOutputResultPrinter implements ResultPrinter {

    @Override
    public void print(Package optimizedPackage) {
        if (optimizedPackage == null || optimizedPackage.getItems().size() == 0) {
            System.out.println("-");
        } else {
            List<Item> items = optimizedPackage.getItems();
            for (int i = 0; i < items.size() - 1; i++) {
                System.out.print(items.get(i).getId() + ",");
            }
            System.out.println(items.get(items.size() - 1).getId());
        }
    }
}
