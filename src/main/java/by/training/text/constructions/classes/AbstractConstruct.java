package by.training.text.constructions.classes;

import by.training.text.alphabet.interfaces.Alphabet;
import by.training.text.constructions.interfaces.ConstructUnit;
import by.training.text.units.interfaces.TextUnit;

import java.util.List;

public abstract class AbstractConstruct implements TextUnit, ConstructUnit {

    private Alphabet alphabet;

    public abstract void setText();

    public AbstractConstruct(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
}
