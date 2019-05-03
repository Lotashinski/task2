package by.training.text.vocabulary.classes;

import by.training.text.constructions.classes.Text;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextProcessorTest {

    private TextProcessor textProcessor;

    @Before
    public void init() {
        textProcessor = new VocabularyDefault();
    }

    @Test
    public void getTextUnits() {

        var textUnits = textProcessor.getTextUnits("Hello, World");

        assertTrue(textUnits.get(0).getText().equals("Hello"));

        assertTrue(textUnits.get(1).getText().equals(","));

        assertTrue(textUnits.get(2).getText().equals("World"));
    }

    @Test
    public void getSentences() {

        var sentences = textProcessor.getSentences("Hello! World!");

        assertTrue(sentences.get(0).getText().equals("Hello!"));
        assertTrue(sentences.get(1).getText().equals("World!"));
    }

    @Test
    public void getParagraphs() {

        var firstParagraph = "First paragraph!";
        var secondParagraph = "Second paragraph.";

        var paragraphs = textProcessor.getParagraphs(firstParagraph + "\n" + secondParagraph);

        assertTrue(paragraphs.get(0).getText().equals(firstParagraph));
        assertTrue(paragraphs.get(1).getText().equals(secondParagraph));
    }

    @Test
    public void getText() {

        var inputText =
               "Hello! World!";
        try {
            Text text = new Text(inputText, (Vocabulary) textProcessor, textProcessor);

            System.out.println(inputText);
            System.out.println(text.getText());

            assertTrue(inputText.equals(text.getText()));
        } catch (Exception e) {
            assert false;
        }
    }
}
