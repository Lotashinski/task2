package by.training.text.units.interfaces;

import java.util.Optional;

public interface TextUnit {

    int length();

    String getText();

    boolean equals(TextUnit unit);
}
