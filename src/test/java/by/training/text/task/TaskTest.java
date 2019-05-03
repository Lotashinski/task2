package by.training.text.task;

import by.training.text.constructions.classes.Text;
import by.training.text.units.classes.Word;
import by.training.text.units.exceptions.IllegalTextUnitTypeException;
import by.training.text.vocabulary.classes.TextProcessorTest;
import by.training.text.vocabulary.classes.VocabularyDefault;
import by.training.text.vocabulary.interfaces.TextProcessor;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TaskTest {

    // test text from file
    String input;

    Text text;

    VocabularyDefault vocabularyDefault;

    @Before
    public void init() {
        var path = "placebo.txt";
        var buffer = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String s;
            while ((s = reader.readLine()) != null) {
                buffer.append(s + "\n");
            }

            input = buffer.toString();

            vocabularyDefault = new VocabularyDefault();

            text = new Text(input, vocabularyDefault, vocabularyDefault);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalTextUnitTypeException te) {
            assert false;
        }
        System.out.println(input);
    }

    @Test
    public void option2() {
        var log = LogManager.getRootLogger();
        text.getSenteces().stream()
                .sorted((left, right) -> {
                    var countLeft = left.getUnits().stream()
                            .filter(unit -> unit instanceof Word)
                            .count();
                    var countRight = right.getUnits().stream()
                            .filter(unit -> unit instanceof Word)
                            .count();
                    return Long.compare(countLeft, countRight);
                })
                .peek(sentence -> log.info(String.format("count (%d): %s", sentence.getUnits().stream()
                        .filter((unit -> unit instanceof Word))
                        .count(),
                        sentence.getText())))
                .collect(Collectors.toList());
    }
}
