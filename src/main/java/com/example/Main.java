package com.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        final ProductRating userRating = new ProductRating();
        System.out.println("Ocena przed zmiana: " + userRating.getScore());
        userRating.setScore(5);
        System.out.println("Ocena po zmianie: " + userRating.getScore());
        System.out.println(TimeUnit.HOURS.toMinutes(24));
    }
}
