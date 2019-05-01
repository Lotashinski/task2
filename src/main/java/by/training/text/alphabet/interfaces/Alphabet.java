package by.training.text.alphabet.interfaces;

public interface Alphabet {
    boolean isPunctuationMark(String text);

    boolean isLetter(char symbol);

    boolean isAvoidWordSymbol(char symbol);

    boolean isAvoidWord(String text);
}
