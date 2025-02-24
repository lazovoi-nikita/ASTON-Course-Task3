package by.aston.task2.interfaces;

import java.util.Collection;
import java.util.Comparator;

public interface IList<T> {
    boolean add(T element);
    boolean addAll(Collection<T> collection);
    T get(int index);
    boolean remove(int index);
    int size();
    void sort(Comparator<? super T> comparator);
    boolean checkSorted();
}
