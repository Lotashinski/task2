package by.training.text.vocabulary.interfaces;

import by.training.text.constructions.classes.Paragraph;
import by.training.text.constructions.classes.Sentence;
import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.interfaces.TextUnit;

import java.util.List;

public interface Vocabulary {

    boolean isDigit(char symbol);

    boolean isLetter(char symbol);

    boolean isValidWordSymbol(char symbol);

    boolean isValidWord(String text);

    boolean isPunctuationMark(String text);

    boolean isValidNumericSymbol(char text);

    boolean isNumeric(String text);
}
