package by.training.text.vocabulary.interfaces;

import by.training.text.constructions.classes.Paragraph;
import by.training.text.constructions.classes.Sentence;
import by.training.text.units.classes.AbstractUnit;

import java.util.List;

public interface TextProcessor {

    List<AbstractUnit> getTextUnits(String text);

    List<Sentence> getSentences(String text);

    List<Paragraph> getParagraphs(String text);
}
