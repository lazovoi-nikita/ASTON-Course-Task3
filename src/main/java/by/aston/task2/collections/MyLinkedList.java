package by.aston.task2.collections;

import by.aston.task2.interfaces.IList;

import java.util.Collection;
import java.util.Comparator;

public class MyLinkedList<T extends Comparable<T>> implements IList<T> {
    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T element) {
            this.value = element;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private static boolean COLLECTION_SORTED = false;

    public MyLinkedList() {
        tail = head = null;
    }

    public MyLinkedList(Collection<T> collection) {
        addAll(collection);
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.value = element;
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> collection) {
        for (T element : collection) {
            add(element);
        }
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return findByIndex(index).value;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node<T> current = findByIndex(index);

        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (checkSorted()) {
            return;
        }
        T temp;
        for (Node<T> item = head; item.next != null; item = item.next) {
            for (Node<T> innerItem = item.next; innerItem != null; innerItem = innerItem.next) {
                if (comparator.compare(item.value, innerItem.value) >= 0) {
                    temp = item.value;
                    item.value = innerItem.value;
                    innerItem.value = temp;
                }
            }
        }
        COLLECTION_SORTED = true;
    }

    @Override
    public boolean checkSorted() {
        if (COLLECTION_SORTED) {
            return false;
        }

        for (Node<T> item = head; item.next != null; item = item.next) {
            if ((item.value).compareTo(item.next.value) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node<T> item = head; item != null; item = item.next) {
            if (item.next != null) {
                builder.append(item.value).append(" -> ");
            } else {
                builder.append(item.value);
            }
        }
        return builder.toString();
    }

    private Node<T> findByIndex(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
