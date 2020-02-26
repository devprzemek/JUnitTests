package com.example;

import org.junit.Assert;
import org.junit.Test;


public class ProductRatingTest{
    @Test
    public void shouldCreateInstance(){
        final ProductRating rating = new ProductRating();
        Assert.assertEquals(0, rating.getScore());
    }
    @Test
    public void shouldSetScore(){
        final ProductRating rating = new ProductRating();
        rating.setScore(5);
        Assert.assertEquals(5, rating.getScore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setScoreLessThanZero(){
        final ProductRating rating = new ProductRating();
        rating.setScore(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setScoreMoreThanFive(){
        final ProductRating rating = new ProductRating();
        rating.setScore(100);
    }

    @Test
    public void setScoreAsMaxPossibleValue(){
        final ProductRating rating = new ProductRating();
        rating.setScore(5);
        Assert.assertEquals(5, rating.getScore());
    }

    @Test
    public void setScoreAsMinPossibleValue(){
        final ProductRating rating = new ProductRating();
        rating.setScore(0);
        Assert.assertEquals(0, rating.getScore());
    }
}