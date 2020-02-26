package com.example;


import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {
    @Test()
    public void create(){
        final Note note = Note.of("Alex Wawrinka", 4.5f);
        assertEquals("Alex Wawrinka", note.getName());
        assertEquals(4.5f, note.getGradeNote(), 0.01f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNullName(){
        Note.of(null, 4.5f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createEmptyName(){
        Note.of("    ", 4.5f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTooLowNote(){
        Note.of("Alex Wawrinka", 1.6f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTooHighNote(){
        Note.of("Alex Wawrinka", 6.6f);
    }
}
