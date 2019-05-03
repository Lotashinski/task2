package by.training.text.vocabulary.classes;

import by.training.text.constructions.classes.Paragraph;
import by.training.text.constructions.classes.Sentence;
import by.training.text.units.classes.AbstractUnit;
import by.training.text.units.classes.Numeric;
import by.training.text.units.classes.PunctuationMark;
import by.training.text.units.classes.Word;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.exceptions.TextFormatException;
import by.training.text.vocabulary.interfaces.TextProcessor;
import by.training.text.vocabulary.interfaces.Vocabulary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VocabularyDefault implements Vocabulary, TextProcessor {

    private String punctuationsMarks;

    private String endSentencePunctuationMarks;

    private String validSymbols;

    private String alphabet;

    private String digits;

    private String validDigitsPrefixes;

    private String newParagraph = "\n";

    public VocabularyDefault() {
        this.punctuationsMarks = ".!?\",()";
        this.endSentencePunctuationMarks = ".?!";
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.validSymbols = "-";
        this.digits = "1234567890";
        this.validDigitsPrefixes = ".%+-/*=^e";
    }

    public VocabularyDefault(String punctuationsMarks, String validSymbols, String alphabet) {
        this.punctuationsMarks = punctuationsMarks;
        this.validSymbols = validSymbols;
        this.alphabet = alphabet;
    }

    @Override
    public boolean isPunctuationMark(String text) {
        return punctuationsMarks.contains(text);
    }

    @Override
    public boolean isLetter(char symbol) {
        return alphabet.contains(("" + symbol).toLowerCase());
    }

    @Override
    public boolean isValidWordSymbol(char symbol) {
        return validSymbols.indexOf(symbol) >= 0;
    }

    @Override
    public boolean isDigit(char symbol) {
        return digits.indexOf(symbol) >= 0;
    }

    @Override
    public boolean isValidNumericSymbol(char symbol) {
        return validDigitsPrefixes.indexOf(symbol) >= 0;
    }

    private List<AbstractUnit> wordController(String text) throws TextFormatException {

        try {

            if (isValidWord(text))
                return Arrays.asList(new Word(text, this));

            if (isNumeric(text))
                return Arrays.asList(new Numeric(text, this));

            for (char pMark : punctuationsMarks.toCharArray()) {
                if (text.endsWith("" + pMark)) {

                    var punctuationMark = new PunctuationMark("" + pMark, this);

                    var unit = wordController(text.substring(0, text.length() - punctuationMark.length()));

                    return Arrays
                            .asList(unit.get(0), punctuationMark);
                }
            }

        } catch (IllegalTextUnitTypeException e) {
            throw new TextFormatException("", e);
        }
        throw new TextFormatException("text not recognized");
    }

    @Override
    public List<AbstractUnit> getTextUnits(String text) {
        var ret = new ArrayList<AbstractUnit>();
        Arrays.stream(text.split(" "))
                .filter((txt) -> txt.length() > 0)
                .forEach((txt) -> {
                    try {
                        ret.addAll(this.wordController(txt));
                    } catch (TextFormatException e) {
                        // ignore unsupported region
                    }
                });
        return ret;
    }

    @Override
    public boolean isValidWord(String text) {
        if (text.length() == 0)
            return false;

        char[] chars = text.toCharArray();

        // first characters is letters
        if (!isLetter(chars[0]) && !isLetter(chars[chars.length - 1]))
            return false;

        // avoids repeating two valid characters in a row
        for (int i = 1; i < chars.length; ++i) {

            char thisChar = chars[i];
            char lastChar = chars[i - 1];

            if (!isLetter(thisChar)
                    && !(isValidWordSymbol(thisChar) && isLetter(lastChar)))
                return false;
        }
        return true;
    }

    @Override
    public boolean isNumeric(String text) {
        if (text.length() == 0)
            return false;

        char[] chars = text.toCharArray();

        for (char thisChar : chars) {

            if (!isDigit(thisChar) && !isValidNumericSymbol(thisChar))
                return false;
        }

        return true;
    }

    @Override
    public List<Sentence> getSentences(String text) {
        var ret = new ArrayList<Sentence>();
        Matcher matcher = Pattern.compile("([^" + endSentencePunctuationMarks + "]+[" + endSentencePunctuationMarks + "])").matcher(text);
        while (matcher.find()) {
            try {
                ret.add(new Sentence(matcher.group(1), this, this));
            } catch (IllegalTextUnitTypeException e) {
                // ignore
            }
        }
        return ret;
    }

    @Override
    public List<Paragraph> getParagraphs(String text) {
        var ret = new ArrayList<Paragraph>();
        Matcher matcher = Pattern.compile("[" + newParagraph + "]").matcher(text);
        while (matcher.find()) {
            try {
                var buf = matcher.group(1);
                ret.add(new Paragraph(buf, this, this));
            } catch (IllegalTextUnitTypeException e) {

            }
        }
        return ret;
    }
}
