package by.training.text.constructions.classes;

import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.ArrayList;
import java.util.List;

public class Text extends AbstractConstruct {

    private List<Paragraph> paragraphs;

    public Text(String text, Vocabulary vocabulary, TextProcessor textProcessor) throws IllegalTextUnitTypeException {
        super(vocabulary, textProcessor);
        setText(text);
    }

    @Override
    public List<Paragraph> getUnits() {
        return paragraphs;
    }

    @Override
    public int count() {
        return getUnits().size();
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        paragraphs = getTextProcessor().getParagraphs(text);
    }

    @Override
    public int length() {
        return getUnits().stream()
                .map(paragraph -> paragraph.length())
                .reduce((left, right) -> left + 1 + right)
                .get();
    }

    @Override
    public String getText() {
        return paragraphs.stream()
                .map((paragraphs) -> paragraphs.getText())
                .reduce((left, right) -> left + " " + right)
                .get();
    }

    public List<Sentence> getSenteces(){
        return getUnits().stream()
                .map(paragraph -> new ArrayList(paragraph.getUnits()))
                .reduce((left, right) -> {
                    left.addAll(right);
                    return left;
                })
                .get();
    }

    public List<AbstractUnit> getAbstractUnits() {
        return getSenteces().stream()
                .map(sentence -> new ArrayList(sentence.getUnits()))
                .reduce((left, right) -> {
                    left.addAll(right);
                    return left;
                })
                .get();
    }

}
