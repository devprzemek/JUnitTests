package com.example;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryItemImplTest {
    @Test
    public void create(){
        final InventoryItem item = InventoryItemImpl.of("miecz", 2.50);
        assertThat(item.getName()).isEqualTo("miecz");
        assertThat(item.getWeight()).isEqualTo(2.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullName(){
       InventoryItemImpl.of(null, 2.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithEmptyName(){
        InventoryItemImpl.of("", 2.50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNegativeWeight(){
        InventoryItemImpl.of("miecz", -2.50);
    }

    @Test
    public void equalAndHashCode(){
        EqualsVerifier.forClass(InventoryItemImpl.class).verify();
    }

    @Test
    public void toStringNotification(){
        final InventoryItem item = InventoryItemImpl.of("miecz", 2.5);
        assertThat(item.toString()).isEqualTo("miecz, 2.5");
    }


}
