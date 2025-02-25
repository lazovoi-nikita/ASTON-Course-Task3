package by.aston.task2.interfaces;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public interface IList<T> {
    boolean add(T element);
    boolean addAll(Collection<T> collection);
    T get(int index);
    boolean remove(int index);
    int size();
    void sort(Comparator<? super T> comparator);
    boolean checkSorted();
    static <T extends Comparable<? super T>> void sort(Collection<T> collection) {
        @SuppressWarnings("unchecked") T[] array = collection.toArray((T[]) new Comparable[collection.size()]);
        T temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        collection.clear();
        Collections.addAll(collection, array);
    }
}
