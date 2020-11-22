package com.bogdanguranda.deliverypackageoptimizer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Package {
    private Double weightLimit;
    private List<Item> items = new ArrayList<>();

    public Package() {

    }

    public Package(Double weightLimit, List<Item> items) {
        this.weightLimit = weightLimit;
        this.items = items;
    }

    public Double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Package otherPackage = (Package) other;
        return weightLimit.equals(otherPackage.weightLimit) &&
                Objects.equals(items, otherPackage.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightLimit, items);
    }
}
