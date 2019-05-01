package by.training.text.units.classes;

import by.training.text.alphabet.interfaces.Alphabet;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.units.interfaces.TextUnit;

public abstract class AbstractUnit implements TextUnit {

    private Alphabet alphabet;

    public AbstractUnit(Alphabet alphabet) {

        this.alphabet = alphabet;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public abstract void setText(String text) throws IllegalTextUnitTypeException;
}
