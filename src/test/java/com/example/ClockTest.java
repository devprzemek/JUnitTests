package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClockTest {
    @Test
    public void create(){
       final  Clock properClock = Clock.of(12, 45);
        assertNotNull(properClock);
        assertEquals(12, properClock.getHours());
        assertEquals(45, properClock.getMinutes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void clockWithHoursLessThanZero(){
        Clock.of(-12, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void clockWithHoursMoreThan23(){
        Clock.of(25, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void clockWithMinutesLessThanZero(){
        Clock.of(12, -45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void clockWithMinutesMoreThan59(){
        Clock.of(25, 65);
    }

    @Test
    public void addMinutesNoHourSkip(){
        final Clock clock = Clock.of(10, 20).add(20);
        assertEquals(10, clock.getHours());
        assertEquals(40, clock.getMinutes());
    }

    @Test
    public void addMinutesHourSkip(){
        final Clock clock = Clock.of(10, 20).add(45);
        assertEquals(11, clock.getHours());
        assertEquals(5, clock.getMinutes());
    }

    @Test
    public void addMinutesHourAndDaySkip(){
        final Clock clock = Clock.of(23, 40).add(20);
        assertEquals(0, clock.getHours());
        assertEquals(0, clock.getMinutes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNegativeMinutes(){
        Clock.of(10, 20).add(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullClock(){
        Clock.of(10, 20).add(null);
    }

    @Test
    public void addClockHourSkip(){
        final Clock clock = Clock.of(10, 20).add(Clock.of(0, 40));
        assertEquals(11, clock.getHours());
        assertEquals(0, clock.getMinutes());
    }

    @Test
    public void addClockHourAndDaySkip(){
        final Clock clock = Clock.of(23, 40).add(Clock.of(1, 20));
        assertEquals(1, clock.getHours());
        assertEquals(0, clock.getMinutes());
    }
}
