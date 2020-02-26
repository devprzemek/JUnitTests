package com.example.imitation;

import com.example.Note;

import java.io.IOException;
import java.util.List;

public interface NoteStorage {
    List<Note> getAllNotesOf(String name);
    void add(Note note) throws IOException;
    void clear();
}
