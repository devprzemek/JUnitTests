package com.example;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Clock implements Serializable {

    private final short hours;
    private final short minutes;

    private static final int MINUTES_PER_HOUR = (int) TimeUnit.HOURS.toMinutes(24);

    private Clock(final short hours, final short minutes){
        this.hours = hours;
        this.minutes = minutes;
    }


    public static Clock of(final int hours, final int minutes){
        if(hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60){
            throw new IllegalArgumentException("Invalid time specification.");
        }
        return new Clock((short) hours, (short) minutes);
    }

    public int  getHours() {
        return hours;
    }

    public int  getMinutes() {
        return minutes;
    }

    public Clock add(final int minutes){
        if(minutes < 0){
            throw new IllegalArgumentException("Invalid minutes specification.");
        }
        final int newMinutes = getMinutes() + minutes;
        final int newHours = (getHours() + (newMinutes / 60)) % 24;

        return new Clock((short) newHours, (short)(newMinutes % 60));
    }

    public Clock add(final Clock rightSide){
        if(rightSide == null){
            throw new IllegalArgumentException("Cannot add null clock.");
        }
        final int newMinutes = getMinutes() + rightSide.minutes;
        final int newHours = (getHours() + rightSide.hours + newMinutes / 60) % 24;

        return new Clock((short) newHours, (short) (newMinutes % 60));
    }

}
