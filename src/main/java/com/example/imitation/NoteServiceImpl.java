package com.example.imitation;

import com.example.Note;
import com.google.common.base.Preconditions;

import java.io.IOException;
import java.util.List;

public class NoteServiceImpl implements NoteService{
    private final NoteStorage storageService;

    public static NoteService createWith(final  NoteStorage storageService){
        return new NoteServiceImpl(storageService);
    }

    private NoteServiceImpl(final NoteStorage storageService){
        this.storageService = storageService;
    }

    @Override
    public void add(Note note) throws IOException {
//        if(note == null){
//            throw new  IllegalArgumentException();
//        }
        Preconditions.checkArgument(note != null);

        storageService.add(note);
    }

    @Override
    public float averageOf(String name) {

//        if(name == null || name.trim().isEmpty()){
//            throw new IllegalArgumentException();
//        }

        Preconditions.checkArgument( name != null);

        List<Note> notes = storageService.getAllNotesOf(name);

        float sum = 0f;
        if(notes.isEmpty()){
            return sum;
        }

        for(final Note note : notes){
            sum += note.getGradeNote();
        }

        return sum / notes.size();
    }

    @Override
    public void clear() {
        storageService.clear();
    }
}
