package by.training.text.constructions.classes;

import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.List;

public class Text extends AbstractConstruct {

    private List<Paragraph> paragraphs;

    public Text(String text, Vocabulary vocabulary, TextProcessor textProcessor) throws IllegalTextUnitTypeException {
        super(vocabulary, textProcessor);
    }

    @Override
    public List<Paragraph> getUnits() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void setText(String text) throws IllegalTextUnitTypeException {
        paragraphs = getTextProcessor().getParagraphs(text);
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public String getText() {
        return paragraphs.stream()
                .map((paragraphs) -> paragraphs.getText())
                .reduce((left, right) -> left + " " + right)
                .get();
    }
}
