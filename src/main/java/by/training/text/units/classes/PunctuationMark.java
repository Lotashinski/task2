package by.training.text.units.classes;


import by.training.text.alphabet.interfaces.Alphabet;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;

public class PunctuationMark extends AbstractUnit {

    private String text;

    public PunctuationMark(String text, Alphabet alphabet) throws IllegalTextUnitTypeException {
        super(alphabet);
        setText(text);
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        if (text.length() == 0 || !this.getAlphabet().isPunctuationMark(text))
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
