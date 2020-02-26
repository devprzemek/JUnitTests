package com.example.imitation;

import com.example.Note;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.util.List;

public class NoteStorageMock implements NoteStorage  {
    private final Multimap<String, Note> notes = ArrayListMultimap.create();

    @Override
    public List<Note> getAllNotesOf(final String name) {
        return (List<Note>) notes.get(name);
    }

    @Override
    public void add(Note note) throws IOException{
        notes.put(note.getName(), note);
    }

    @Override
    public void clear() {
        notes.clear();
    }

}
