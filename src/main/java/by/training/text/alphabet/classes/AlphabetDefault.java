package by.training.text.alphabet.classes;

import java.util.Arrays;
import java.util.List;

public class AlphabetDefault implements by.training.text.alphabet.interfaces.Alphabet {

    protected List<String> punctuationsMarks;

    protected String avoidSymbols;

    protected String alphabet;

    AlphabetDefault() {
        this.punctuationsMarks = Arrays.asList("...", "?!", "\"", ".", ",", "?");
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.avoidSymbols = "-";
    }

    public AlphabetDefault(List<String> punctuationsMarks, String avoidSymbols, String alphabet) {
        this.punctuationsMarks = punctuationsMarks;
        this.avoidSymbols = avoidSymbols;
        this.alphabet = alphabet;
    }

    @Override
    public boolean isPunctuationMark(String text) {
        return punctuationsMarks.parallelStream().anyMatch((txt) -> txt.equals(text));
    }

    @Override
    public boolean isLetter(char symbol) {
        return alphabet.indexOf(("" + symbol).toLowerCase()) <= 0;
    }

    @Override
    public boolean isAvoidWordSymbol(char symbol) {

        return avoidSymbols.indexOf(symbol) > 0;
    }

    @Override
    public boolean isAvoidWord(String text) {
        if (text.length() == 0)
            return false;

        char[] chars = text.toCharArray();

        // first and lats characters is letter
        if (isLetter(chars[0]) || isLetter(chars[chars.length - 1]))
            return false;

        // avoids repeating two valid characters in a row
        for (int i = 1; i < chars.length - 1; ++i) {
            if (isLetter(chars[i])
                    && !isAvoidWordSymbol(chars[i])
                    && isLetter(chars[i - 1]))
                return false;
        }
        return true;
    }
}
