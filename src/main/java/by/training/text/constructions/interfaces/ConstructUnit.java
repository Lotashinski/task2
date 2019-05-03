package by.training.text.constructions.interfaces;

import by.training.text.units.classes.AbstractUnit;

import java.util.List;

public interface ConstructUnit<T> {

    List<T> getUnits();

    int count();
}
