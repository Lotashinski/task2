package by.training.text.units.classes;


import by.training.text.vocabulary.interfaces.Vocabulary;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;

import java.util.Optional;

public class PunctuationMark extends AbstractUnit {

    private String text;

    public PunctuationMark(String text, Vocabulary vocabulary) throws IllegalTextUnitTypeException {
        super(vocabulary);
        setText(text);
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        if (text.length() == 0 || !this.getVocabulary().isPunctuationMark(text))
            throw new IllegalTextUnitTypeException("illegal input text");
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
