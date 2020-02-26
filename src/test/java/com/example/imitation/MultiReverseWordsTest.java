package com.example.imitation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MultiReverseWordsTest {
    private ReverseLetters reverseLetters;
    private ReverseLetters reverseWords;

    @Before
    public void before(){
        reverseLetters = mock(ReverseLetters.class);
        reverseWords = ReverseWords.with(reverseLetters);
    }

    @Test
    public void testReversePhrase(){
        when(reverseLetters.apply("Ala")).thenReturn("alA");
        when(reverseLetters.apply("ma")).thenReturn("am");
        when(reverseLetters.apply("kota")).thenReturn("atok");
        assertEquals(reverseWords.apply("Ala ma kota"), "alA am atok");
        verify(reverseLetters, times(3)).apply(any(String.class));
    }

    @Test
    public void testReverseUpperPhrase(){
        when(reverseLetters.apply("Ala")).thenReturn("ALA");
        when(reverseLetters.apply("ma")).thenReturn("AM");
        when(reverseLetters.apply("kota")).thenReturn("ATOK");
        assertEquals(reverseWords.apply("Ala ma kota"), "ALA AM ATOK");
        verify(reverseLetters, atLeastOnce()).apply(any(String.class));
    }

    @Test
    public void testReverseForceUppercase(){
        when(reverseLetters.apply("ALA")).thenReturn("ALA");
        when(reverseLetters.apply("MA")).thenReturn("AM");
        when(reverseLetters.apply("KOTA")).thenReturn("ATOK");
        assertEquals(reverseWords.apply("ALA MA KOTA"), "ALA AM ATOK");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseForceUppercase_invalidData(){
        doAnswer(new Answer<String>(){
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                final String phrase = (String) invocationOnMock.getArgument(0);
                final String uppercase = phrase.toUpperCase();
                if(!phrase.equals(uppercase)){
                    throw new IllegalArgumentException();
                }
                throw new UnsupportedOperationException("Brak implepentacji");
            }

        }).when(reverseLetters).apply(any(String.class));

        reverseWords.apply("Ala ma kota");
    }

    @Test
    public void testReversePhrase_wordReverseCalled(){
        when(reverseLetters.apply("Ala")).thenReturn("alA");
        reverseWords.apply("Ala");
        verify(reverseLetters, times(1)).apply(any(String.class));
    }



}
