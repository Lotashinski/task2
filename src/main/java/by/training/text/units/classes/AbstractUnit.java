package by.training.text.units.classes;

import by.training.text.vocabulary.interfaces.Vocabulary;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.units.interfaces.TextUnit;

public abstract class AbstractUnit implements TextUnit {

    private Vocabulary vocabulary;

    public AbstractUnit(Vocabulary vocabulary) {

        this.vocabulary = vocabulary;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public abstract void setText(String text) throws IllegalTextUnitTypeException;

    @Override
    public boolean equals(TextUnit unit) {
        return getText().equals(unit.getText());
    }
}
