package by.training.text.constructions.classes;

import by.training.text.constructions.interfaces.ConstructUnit;
import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.units.interfaces.TextUnit;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

public abstract class AbstractConstruct extends AbstractUnit  implements TextUnit, ConstructUnit {

    private TextProcessor textProcessor;

    public AbstractConstruct(Vocabulary vocabulary, TextProcessor textProcessor)
            throws IllegalTextUnitTypeException {
        super(vocabulary);
        this.textProcessor = textProcessor;
    }

    public TextProcessor getTextProcessor() {
        return textProcessor;
    }
}
