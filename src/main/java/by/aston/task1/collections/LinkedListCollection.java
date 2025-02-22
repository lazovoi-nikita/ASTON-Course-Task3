package by.aston.task1.collections;

import java.util.LinkedList;

public class LinkedListCollection<T>  extends GenericList<T> {
    public LinkedListCollection() {
        super(new LinkedList<>());
    }
}
