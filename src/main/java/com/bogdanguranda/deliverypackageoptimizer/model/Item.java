package com.bogdanguranda.deliverypackageoptimizer.model;

import java.util.Objects;

public class Item {
    private Long id;
    private Long weight;
    private Long cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                weight.equals(item.weight) &&
                cost.equals(item.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, cost);
    }
}
