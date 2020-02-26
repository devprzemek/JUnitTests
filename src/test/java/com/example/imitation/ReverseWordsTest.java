package com.example.imitation;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class ReverseWordsTest {
    private ReverseWords reverseWords;

    @Before
    public void before(){
        final ReverseLetters reversePhrase = mock(ReverseLetters.class);
        when(reversePhrase.apply("")).thenReturn("");
        when(reversePhrase.apply("Zamieniona")).thenReturn("anoineimaZ");
        when(reversePhrase.apply("kolejność")).thenReturn("ćśonjelok");
        when(reversePhrase.apply("liter")).thenReturn("retil");

        reverseWords = ReverseWords.with(reversePhrase);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithNullReversePhrase(){
        ReverseWords.with(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void apply_null(){
        reverseWords.apply(null);
    }

    @Test
    public void apply_empty(){
        reverseWords.apply("");
    }

    @Test
    public void apply_plainText(){
        assertEquals("anoineimaZ ćśonjelok retil", reverseWords.apply("Zamieniona kolejność liter"));
    }

    @Test
    public void apply_textWithSpaces(){
        assertEquals("  anoineimaZ   ćśonjelok   retil  ", reverseWords.apply("  Zamieniona   kolejność   liter  "));
    }
}
