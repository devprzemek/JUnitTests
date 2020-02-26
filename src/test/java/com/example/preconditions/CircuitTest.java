package com.example.preconditions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CircuitTest {
    @Test(expected = IllegalArgumentException.class)
    public void negativeRadius(){
        final Circle circle = Circle.withRadius(-5.0);
    }

    @Test
    public void positiveRadius(){
        final Circle circle = Circle.withRadius(5.0);
        assertThat(circle.getArea()).isEqualTo(Math.PI * 5.0 * 5.0);
        assertThat(circle.getRadius()).isEqualTo(5.0);
        assertThat(circle.getCircuit()).isEqualTo(Math.PI * 5.0 * 2.0);
    }

    @Test
    public void zeroRadius(){
        final Circle circle = Circle.withRadius(0.0);
        assertThat(circle.getArea()).isZero();
        assertThat(circle.getRadius()).isZero();
        assertThat(circle.getCircuit()).isZero();
    }
}
