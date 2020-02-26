package com.example;

import java.util.List;

public interface Inventory extends Iterable<InventoryItem> {
    void setWeightLimit(double weightLimit);
    void setSizeLimit(int sizeLimit);

    void addItem(InventoryItem item);
    void removeItem(InventoryItem item);

    InventoryItem getItem(int index);
    List<InventoryItem> getAllItems();

    int getSize();
    double getTotalWeight();
}
