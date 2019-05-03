package by.training.text.constructions.classes;

import by.training.text.vocabulary.classes.VocabularyDefault;
import by.training.text.vocabulary.interfaces.Vocabulary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {

    VocabularyDefault vocabulary;

    @Before
    public void init(){
        vocabulary = new VocabularyDefault();
    }

    @Test
    public void setText() {
        try {

            var sentence = new Sentence("Hello!", vocabulary, vocabulary);
            var units = sentence.getUnits();

            assertTrue(units.get(0).getText().equals("Hello"));
            assertTrue(units.get(1).getText().equals("!"));
        }
        catch (Exception e){
            assert false;
        }
    }

    @Test
    public void getText() {
        try {

            var inputText = "Hello!";

            var sentence = new Sentence(inputText, vocabulary, vocabulary);
            var outputText = sentence.getText();

            assertTrue(outputText.equals(inputText));
        }
        catch (Exception e){
            assert false;
        }
    }
}