package com.example;

import java.io.Serializable;

public class ProductRating implements Serializable {
    private final int MAX_SCORE = 5;
    private final int MIN_SCORE = 0;
    private short score;

    public void setScore(final int score){
        if(score < MIN_SCORE || score > MAX_SCORE){
            throw new IllegalArgumentException("Invalid score");
        }
        this.score = (short) score;
    }

    public int getScore(){
        return score;
    }
}
