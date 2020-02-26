package com.example.assertions;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {
    @Test
    public void createCorrectFraction(){
        final Fraction fraction = Fraction.of(4, 5);
        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isEqualTo(4);
        assertThat(fraction.getDenominator()).isEqualTo(5);
    }

    @Test
    public void createFractions(){
        assertThat(Fraction.of(1, 1)).isSameAs(Fraction.FULL);
        assertThat(Fraction.of(1, 2)).isSameAs(Fraction.HALF);
        assertThat(Fraction.of(1, 3)).isSameAs(Fraction.ONE_THIRD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dividePositiveByZero(){
        Fraction.of(5, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideNegativeByZero(){
        Fraction.of(-5, 0);
    }

    @Test()
    public void divideZeroByZero(){
        assertThat(Fraction.of(0, 0)).isSameAs(Fraction.INDETERMINATE);
    }

//    @Test
//    public void equalsPositive(){
//        assertThat(Fraction.of(2,5)).isEqualTo(Fraction.of(2,5));
//    }
//
//    @Test
//    public void equalsDifferentNumerator(){
//        assertThat(Fraction.of(2,5)).isNotEqualTo(Fraction.of(3,5));
//    }
//
//    @Test
//    public void equalsDifferentDenominator(){
//        assertThat(Fraction.of(3,5)).isNotEqualTo(Fraction.of(3,6));
//    }
//
//    @Test
//    public void equalHash(){
//        assertThat(Fraction.of(3,5).hashCode()).isEqualTo(Fraction.of(3,5).hashCode());
//    }

    @Test
    public void verifyToString(){
        assertThat(Fraction.of(3,5).toString()).isEqualTo("3/5");
    }

    @Test
    public void equalsAndHashCode(){
        EqualsVerifier.forClass(Fraction.class).verify();
    }
}
