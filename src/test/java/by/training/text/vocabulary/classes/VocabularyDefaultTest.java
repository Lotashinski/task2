package by.training.text.vocabulary.classes;

import by.training.text.vocabulary.interfaces.Vocabulary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VocabularyDefaultTest {

    private Vocabulary vocabulary;

    @Before
    public void init(){
        vocabulary = new VocabularyDefault();
    }

    @Test
    public void isPunctuationMark() {

        assertTrue(vocabulary.isPunctuationMark("!"));
        assertTrue(vocabulary.isPunctuationMark("."));

        assertFalse(vocabulary.isPunctuationMark("text"));
    }

    @Test
    public void isLetter() {

        assertTrue(vocabulary.isLetter('a'));
        assertTrue(vocabulary.isLetter('Z'));

        assertFalse(vocabulary.isLetter('/'));
    }

    @Test
    public void isValidWordSymbol() {

        assertTrue(vocabulary.isValidWordSymbol('-'));

        assertFalse(vocabulary.isValidWordSymbol('.'));
    }

    @Test
    public void isValidWord() {

        assertTrue(vocabulary.isValidWord("Hello"));
        assertTrue(vocabulary.isValidWord("double-world"));

        assertFalse(vocabulary.isValidWord("Hello!"));
    }

    @Test
    public void isNumeric(){

        assertTrue(vocabulary.isNumeric("1000"));
        assertTrue(vocabulary.isNumeric("100.5"));

        // 0.5 equally .5
        assertTrue(vocabulary.isNumeric(".5"));

        // exp view
        assertTrue(vocabulary.isNumeric("6.26e-34"));

        // percents
        assertTrue(vocabulary.isNumeric("5%"));
    }
}