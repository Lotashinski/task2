package by.training.text.units.classes;

import by.training.text.vocabulary.interfaces.Vocabulary;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;

import java.util.Optional;

public class Word extends AbstractUnit {

    private String text;

    public Word(String text, Vocabulary vocabulary) throws IllegalTextUnitTypeException {
        super(vocabulary);
        setText(text);
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        if (!this.getVocabulary().isValidWord(text))
            throw new IllegalTextUnitTypeException("text is not word: " + text);
        this.text = text;
    }
}
