package com.example.imitation;

import com.example.Note;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class NoteServiceImplTest {

    private static final float EQUALITY_DELTA = 0.01f;
    private Multimap<String, Note> notes;
    private NoteStorage storage;
    private NoteService noteService;

    @Before
    public void before(){
        notes = ArrayListMultimap.create();
        storage = spy(new NoteStorageMock());
        noteService = NoteServiceImpl.createWith(storage);
    }
//    @Test(expected = IllegalArgumentException.class)
//    public void addNullNote(){
//        noteService.add(null);
//    }
//
//    @Test
//    public void addNote(){
//        noteService.add(Note.of("Jan Kowalski", 5.5f));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void averageOfNullName(){
//        noteService.averageOf(null);
//    }
//
//    @Test
//    public void averageOfNonexistentName(){
//        assertEquals(0.0f, noteService.averageOf("Stefan Nowak"), 0.01f);
//    }
//
//    @Test
//    public void averageOfTwoStudents(){
//        noteService.add(Note.of("Jan Kowalski", 5.5f));
//        noteService.add(Note.of("Jan Kowalski", 4.5f));
//        noteService.add(Note.of("Jan Kowalski", 5.0f));
//        assertEquals(5.0f, noteService.averageOf("Jan Kowalski"), 0.01f);
//
//        noteService.add(Note.of("Stefan Nowak", 3.0f));
//        noteService.add(Note.of("Stefan Nowak", 4.0f));
//        noteService.add(Note.of("Stefan Nowak", 3.2f));
//        assertEquals(3.4f, noteService.averageOf("Stefan Nowak"), 0.01f);
//    }
//
//    @Test
//    public void clearStudentNotes(){
//        noteService.add(Note.of("Jan Kowalski", 5.5f));
//        noteService.add(Note.of("Jan Kowalski", 4.5f));
//        noteService.add(Note.of("Jan Kowalski", 5.0f));
//         assertEquals(5.0f, noteService.averageOf("Jan Kowalski"), EQUALITY_DELTA);
//
//        noteService.clear();
//        assertEquals(0.0f, noteService.averageOf("Jan Kowalski"), 0.01f);
//
//    }
//
//    private NoteStorage createMockedNoteStorage(){
//        final NoteStorage noteStorage = mock(NoteStorage.class);
//
//        doAnswer(new Answer<Void>() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//                final Note note  = (Note) invocationOnMock.getArgument(0);
//                notes.put(note.getName(), note);
//                return null;
//            }
//        }).when(noteService).add(any(Note.class));
//
//        doAnswer(new Answer<Void>() {
//            @Override
//            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
//                notes.clear();
//                return null;
//            }
//        }).when(noteStorage).clear();
//
//        doAnswer(new Answer<List<Note>>(){
//
//            @Override
//            public List<Note> answer(InvocationOnMock invocationOnMock) throws Throwable {
//                final String name = (String) invocationOnMock.getArgument(0);
//                return (List<Note>) notes.get(name);
//            }
//        }).when(noteStorage).getAllNotesOf(any(String.class));
//
//        return noteStorage;
//    }

    @Test(expected = IOException.class)
    public void add_persistenceError() throws IOException{
        doThrow(new IOException()).when(storage).add(any(Note.class));
        noteService.add(Note.of("Jan Kowalski", 4.5f));
    }

}
