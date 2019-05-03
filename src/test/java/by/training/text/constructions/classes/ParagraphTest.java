package by.training.text.constructions.classes;

import by.training.text.vocabulary.classes.VocabularyDefault;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParagraphTest {

    VocabularyDefault vocabulary;


    @Before
    public void init() {
        vocabulary = new VocabularyDefault();
    }

    @Test
    public void setText() {
        try {

            var paragraph = new Paragraph("Hello! World!", vocabulary, vocabulary);
            var units = paragraph.getUnits();

            assertTrue(units.get(0).getText().equals("Hello!"));
            assertTrue(units.get(1).getText().equals("World!"));
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void getText() {
        try {

            var inputText = "Hello! World!";

            var paragraph = new Paragraph(inputText, vocabulary, vocabulary);

            assertTrue(paragraph.getText().equals(inputText));
        } catch (Exception e) {
            assert false;
        }
    }
}