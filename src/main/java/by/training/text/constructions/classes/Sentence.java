package by.training.text.constructions.classes;

import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.classes.PunctuationMark;
import by.training.text.units.classes.Word;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.List;
import java.util.Optional;

public class Sentence extends AbstractConstruct {

    private List<AbstractUnit> textUnits;

    public Sentence(String text, Vocabulary vocabulary, TextProcessor textProcessor)
            throws IllegalTextUnitTypeException {
        super(vocabulary, textProcessor);
        setText(text);
    }

    @Override
    public void setText(String text) {
        textUnits = getTextProcessor().getTextUnits(text);
    }

    @Override
    public List<AbstractUnit> getUnits() {
        return textUnits;
    }

    @Override
    public int count() {
        return textUnits.size();
    }

    @Override
    public int length() {
        return textUnits.parallelStream()
                .map((unit) -> {
                    if (unit instanceof Word)
                        return unit.length() + 1;
                    return unit.length();
                })
                .reduce(Integer::sum)
                .get() - 1;
    }

    @Override
    public String getText() {
        return "" + textUnits.stream()
                .map((unit) -> ((unit instanceof PunctuationMark) ? "" : " ")
                        + unit.getText())
                .reduce((left, right) -> left + right)
                .get()
                .trim();
    }
}
