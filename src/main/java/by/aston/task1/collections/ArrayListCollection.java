package by.aston.task1.collections;

import java.util.ArrayList;

public class ArrayListCollection<T> extends GenericList<T> {
    public ArrayListCollection() {
        super(new ArrayList<>());
    }
}
