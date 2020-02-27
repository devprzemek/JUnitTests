package com.example;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class InventoryImplTest {
    private Inventory inventory;

    @Before
    public void before(){
        inventory = InventoryImpl.create();
    }

    @Test
    public void setPositiveSizeLimit(){
        inventory.setSizeLimit(5);
        assertThat(inventory.getSizeLimit()).isEqualTo(5);
    }

    @Test
    public void setZeroSizeLimit(){
        inventory.setSizeLimit(0);
        assertThat(inventory.getSizeLimit()).isZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeSizeLimit(){
        inventory.setSizeLimit(-5);
    }

    @Test
    public void lowerSizeLimit(){
        inventory.setSizeLimit(5);
        inventory.setWeightLimit(5.0);

        assertThat(inventory.getSizeLimit()).isEqualTo(5);
        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        inventory.addItem(InventoryItemImpl.of("bread", 0.25));
        inventory.setSizeLimit(3);
        assertThat(inventory.getSizeLimit()).isEqualTo(3);
    }

    @Test(expected = IllegalStateException.class)
    public void sizeLimitTooLow(){
        inventory.setSizeLimit(5);
        assertThat(inventory.getSizeLimit()).isEqualTo(5);
        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        inventory.addItem(InventoryItemImpl.of("bread", 0.25));
        inventory.setSizeLimit(2);
    }

    @Test
    public void setPositiveWeightLimit(){
        inventory.setWeightLimit(20.0);
        assertThat(inventory.getWeightLimit()).isEqualTo(20.0);
    }

    @Test
    public void setZeroWeightLimit(){
        inventory.setWeightLimit(0.0);
        assertThat(inventory.getWeightLimit()).isZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeWeightLimit(){
        inventory.setWeightLimit(-25.0);
    }

    @Test
    public void lowerWeightLimit(){
        inventory.setSizeLimit(3);
        inventory.setWeightLimit(20.0);

        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        inventory.addItem(InventoryItemImpl.of("bread", 0.25));
        inventory.setWeightLimit(10.0);
    }

    @Test(expected = IllegalStateException.class)
    public void weightLimitTooLow(){
        inventory.setSizeLimit(3);
        inventory.setWeightLimit(5.0);

        inventory.addItem(InventoryItemImpl.of("sword", 4.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        inventory.addItem(InventoryItemImpl.of("bread", 0.25));
        inventory.setWeightLimit(4.0);
    }

    @Test
    public void emptyInventoryHasToWeight(){
        assertThat(inventory.getTotalWeight()).isZero();
    }

    @Test
    public void getTotalWeight(){
        inventory.setSizeLimit(2);
        inventory.setWeightLimit(10.0);

        inventory.addItem(InventoryItemImpl.of("sword", 4.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        assertThat(inventory.getTotalWeight()).isEqualTo(5.0, Offset.offset(0.01));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullItem(){
        inventory.addItem(null);
    }

    @Test(expected = IllegalStateException.class)
    public void addExceedingSizeLimit(){
        inventory.setSizeLimit(2);
        inventory.setWeightLimit(5.0);

        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));
        inventory.addItem(InventoryItemImpl.of("bread", 0.25));
    }

    @Test(expected = IllegalStateException.class)
    public void addExceedingWeightLimit(){
        inventory.setSizeLimit(10);
        inventory.setWeightLimit(2.0);

        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
    }

    @Test
    public void add(){
        inventory.setSizeLimit(2);
        inventory.setWeightLimit(5.0);

        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));

        assertThat(inventory.getSize()).isEqualTo(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getItemWithNegativeIndex(){
        inventory.getItem(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceedingEnd(){
        inventory.setSizeLimit(2);
        inventory.setWeightLimit(5.0);

        inventory.addItem(InventoryItemImpl.of("sword", 2.5));
        inventory.addItem(InventoryItemImpl.of("fire ball", 0.5));

        inventory.getItem(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFromEmpty(){
        inventory.getItem(0);
    }

    @Test
    public void get(){
        inventory.setSizeLimit(2);
        inventory.setWeightLimit(5.0);

        final InventoryItem item = InventoryItemImpl.of("sword", 2.5);
        inventory.addItem(item);

        assertThat(inventory.getItem(0)).isSameAs(item);
    }

    @Test
    public void iterator(){
        inventory.setSizeLimit(5);
        inventory.setWeightLimit(5.0);

        final InventoryItem firstItem = InventoryItemImpl.of("sword", 2.5);
        final InventoryItem secondItem = InventoryItemImpl.of("dagger", 1.5);

        inventory.addItem(firstItem);
        inventory.addItem(secondItem);

        assertThat(inventory).containsOnly(firstItem, secondItem);
    }

    @Test
    public void remove(){
        inventory.setSizeLimit(5);
        inventory.setWeightLimit(5.0);

        final InventoryItem item = InventoryItemImpl.of("sword", 2.5);
        inventory.addItem(item);
        inventory.removeItem(item);

        assertThat(inventory).isEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNull(){
        inventory.setSizeLimit(5);
        inventory.setWeightLimit(5.0);

        inventory.removeItem(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonexistent(){
        inventory.setSizeLimit(5);
        inventory.setWeightLimit(5.0);

        final InventoryItem firstItem = InventoryItemImpl.of("sword", 2.5);
        final InventoryItem secondItem = InventoryItemImpl.of("dagger", 1.5);

        inventory.addItem(firstItem);
        inventory.removeItem(secondItem);
    }
}
