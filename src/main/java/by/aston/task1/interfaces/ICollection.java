package by.aston.task1.interfaces;

import java.util.Collection;

public interface ICollection<T> {
    void addFirst(Collection<T> collection);
    void addFirst(T element);
    void addLast(Collection<T> collection);
    void addLast(T element);
    void addCenter(Collection<T> collection);
    void addCenter(T element);
    void remove(Collection<T> collection);
    void remove(T item);
}
