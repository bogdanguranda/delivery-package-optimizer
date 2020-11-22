package com.bogdanguranda.deliverypackageoptimizer.model;

import java.util.Objects;

public class Item {
    private Integer id;
    private Double weight;
    private Integer cost;

    public Item() {

    }

    public Item(Integer id, Double weight, Integer cost) {
        this.id = id;
        this.weight = weight;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
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
