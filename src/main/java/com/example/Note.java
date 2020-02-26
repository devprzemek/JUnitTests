package com.example;

import com.google.common.base.Preconditions;

import java.io.Serializable;

public class Note implements Serializable {
    private final String name;
    private final float gradeNote;

    public static Note of(final String name, final float note){
        Preconditions.checkArgument(name != null, "Imię ucznia nie może byc wartością null.");
        if(name.trim().isEmpty() || note < 2.0f || note > 6.0f){
            throw new IllegalArgumentException("Invalid data specification.");
        }
        return new Note(name, note);
    }

    private Note(final String name, final float note){
        this.name = name;
        this.gradeNote = note;
    }

    public String getName() {
        return name;
    }

    public float getGradeNote() {
        return gradeNote;
    }
}
