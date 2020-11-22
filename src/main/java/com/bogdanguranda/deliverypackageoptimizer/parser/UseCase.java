package com.bogdanguranda.deliverypackageoptimizer.parser;

import com.bogdanguranda.deliverypackageoptimizer.model.Item;

import java.util.List;
import java.util.Objects;

public class UseCase {
    private Double weightLimit;
    private List<Item> allItems;

    public UseCase() {

    }

    public UseCase(Double weightLimit, List<Item> allItems) {
        this.weightLimit = weightLimit;
        this.allItems = allItems;
    }

    public Double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseCase useCase = (UseCase) o;
        return weightLimit.equals(useCase.weightLimit) &&
                Objects.equals(allItems, useCase.allItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightLimit, allItems);
    }
}
