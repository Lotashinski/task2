package by.training.text.constructions.classes;

import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.units.interfaces.TextUnit;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends AbstractConstruct {

    private List<Sentence> sentences;

    public Paragraph(String text, Vocabulary vocabulary, TextProcessor textProcessor) throws IllegalTextUnitTypeException {
        super(vocabulary, textProcessor);
        setText(text);
    }

    @Override
    public List<Sentence> getUnits() {
        return sentences;
    }

    @Override
    public int count() {
        return getUnits().size();
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        sentences = getTextProcessor().getSentences(text);
    }

    @Override
    public int length() {
        return getUnits().stream()
                .map((construct) -> construct.length())
                .reduce((left, right) -> left + right + 1)
                .get();
    }

    @Override
    public String getText() {
        return getUnits().stream()
                .map((constr) -> constr.getText())
                .reduce((left, right) -> left + " " + right)
                .get();
    }

    // return words, numeric, punctuation
    public List<AbstractUnit> getAbstractUnits() {
        return getUnits().stream()
                .map(sentence -> new ArrayList(sentence.getUnits()))
                .reduce((left, right) -> {
                    left.addAll(right);
                    return left;
                })
                .get();
    }
}
