package com.bogdanguranda.deliverypackageoptimizer.model;

import java.util.List;
import java.util.Objects;

public class Package {
    private Long weightLimit;
    private List<Item> items; // TODO: decide which data structure is best to use here

    public Long getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Long weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return weightLimit.equals(aPackage.weightLimit) &&
                Objects.equals(items, aPackage.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightLimit, items);
    }
}
