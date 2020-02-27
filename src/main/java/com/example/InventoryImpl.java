package com.example;

import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryImpl implements Inventory, Serializable {
    private int sizeLimit;
    private double weightLimit;
    private final List<InventoryItem> inventoryItems = new ArrayList<>();

    private InventoryImpl(){
    }

    public static Inventory create(){
        return new InventoryImpl();
    }

    @Override
    public void setWeightLimit(double weightLimit) {
        Preconditions.checkArgument(weightLimit >= 0, "Weight limit cannot be negative.");
        Preconditions.checkState(weightLimit >= getTotalWeight(), "Weight limit is too low.");

        this.weightLimit = weightLimit;
    }

    @Override
    public void setSizeLimit(int sizeLimit) {
        Preconditions.checkArgument(sizeLimit >= 0, "Size limit cannot be negative.");
        Preconditions.checkState(sizeLimit >= inventoryItems.size(), "Size limit is too low.");

        this.sizeLimit = sizeLimit;
    }

    @Override
    public double getWeightLimit() {
        return weightLimit;
    }

    @Override
    public int getSizeLimit() {
        return sizeLimit;
    }

    @Override
    public void addItem(InventoryItem item) {
        Preconditions.checkArgument(item != null, "New item cannot be null.");
        Preconditions.checkState(getSize() < getSizeLimit(), "Cannot exceed size limit.");
        Preconditions.checkState(getTotalWeight() + item.getWeight() <= getWeightLimit() ,"Cannot exceed weight limit." );

        inventoryItems.add(item);
    }

    @Override
    public InventoryItem getItem(int index) {
        return inventoryItems.get(index);
    }

    @Override
    public void removeItem(InventoryItem item) {
        Preconditions.checkArgument( item != null, "Cannot remove null value.");
        Preconditions.checkArgument(inventoryItems.contains(item), "Cannot remove nonexistent item.");

        inventoryItems.remove(item);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return inventoryItems;
    }

    @Override
    public int getSize() {
        return inventoryItems.size();
    }

    @Override
    public double getTotalWeight() {
        double totalWeight = 0.0;
        for(final InventoryItem item : inventoryItems){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    @Override
    public Iterator<InventoryItem> iterator() {
        return inventoryItems.iterator();
    }
}
