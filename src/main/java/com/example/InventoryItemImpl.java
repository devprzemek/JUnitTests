package com.example;

import com.example.preconditions.Circle;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import javax.annotation.Nonnull;
import java.io.Serializable;

public final class InventoryItemImpl implements InventoryItem, Serializable {

    @Nonnull
    private final String name;
    private final double weight;

    private InventoryItemImpl(String name, double weight){
//        Preconditions.checkArgument(!name.isEmpty() && name != null, "No item name specified");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "No item name specified");
        Preconditions.checkArgument(weight >= 0.0, "Item weight cannot be negative.");
        this.name = name;
        this.weight = weight;
    }

    public static InventoryItem of(String name, double weight){
        return new InventoryItemImpl(name, weight);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(weight);
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof InventoryItem)){
            return false;
        }
        final InventoryItem item = (InventoryItem) object;
        return  this.name.equals(item.getName()) && Double.compare(this.weight, item.getWeight()) == 0 || item == this;

    }

    @Override
    public String toString() {
        return new StringBuffer().append(name).append(", ").append(weight).toString();
    }
}
