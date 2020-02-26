package com.example.imitation;

import com.example.Note;

import java.io.IOException;

public interface NoteService {
    void add(Note note) throws IOException;
    float averageOf(String name);
    void clear();
}
