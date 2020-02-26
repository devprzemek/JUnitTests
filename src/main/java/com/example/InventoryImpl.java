package com.example;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class InventoryImpl implements Inventory, Serializable {

    private InventoryImpl(){

    }

    public static Inventory create(){
        return new InventoryImpl();
    }

    @Override
    public void setWeightLimit(double weightLimit) {

    }

    @Override
    public void setSizeLimit(int sizeLimit) {

    }

    @Override
    public void addItem(InventoryItem item) {

    }

    @Override
    public void removeItem(InventoryItem item) {

    }

    @Override
    public InventoryItem getItem(int index) {
        return null;
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public double getTotalWeight() {
        return 0;
    }

    @Override
    public Iterator<InventoryItem> iterator() {
        return null;
    }
}
