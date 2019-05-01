package by.training.text.units.classes;

import by.training.text.alphabet.interfaces.Alphabet;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;

public class Word extends AbstractUnit {

    private String text;

    public Word(String text, Alphabet alphabet) {
        super(alphabet);

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


        this.text = text;
    }
}
