package com.example.assertions;

import com.google.common.annotations.VisibleForTesting;

public final class Fraction {
    private final int denominator; //mianownik
    private final int numerator; //licznik

    @VisibleForTesting
    static final Fraction FULL = Fraction.of(1,1);
    @VisibleForTesting
    static final Fraction HALF = Fraction.of(1,2);
    @VisibleForTesting
    static final Fraction ONE_THIRD = Fraction.of(1,3);

    public static final Fraction INDETERMINATE = Fraction.of(0,0);

    public static Fraction of(int numerator, int denominator){

//        if(denominator == 0){
//            switch (numerator){
//                case 0 :
//                    return INDETERMINATE;
//                default :
//                    throw new IllegalArgumentException("Denominator cannot be equal zero.");
//            }
//        }

        if(denominator == 0 ){
            if (numerator == 0)
                return INDETERMINATE;
            else
                throw new IllegalArgumentException("Denominator cannot be equal zero.");
        }

        if(numerator == 1){
            switch (denominator){
                case 1 :
                    return FULL;
                case 2 :
                    return HALF;
                case 3 :
                    return ONE_THIRD;
            }
        }

        return new Fraction(numerator, denominator);
    }

    private Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double doubleValue(){
        return (double) numerator / (double) denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Fraction)){
            return false;
        }

        final Fraction fraction = (Fraction) object;
        if(this.numerator == fraction.getNumerator() && this.denominator == fraction.getDenominator()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return numerator + denominator;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(numerator).append("/").append(denominator).toString();
    }
}
