package by.training.text.units.classes;

import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.Optional;

public class Numeric extends AbstractUnit {

    private String text;

    public Numeric(String text, Vocabulary vocabulary) throws IllegalTextUnitTypeException {
        super(vocabulary);
        setText(text);
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        if (!getVocabulary().isNumeric(text))
            throw new IllegalTextUnitTypeException("is not numeric: " + text);
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public String getText() {
        return text;
    }
}
