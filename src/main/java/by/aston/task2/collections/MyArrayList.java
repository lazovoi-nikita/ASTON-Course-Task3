package by.aston.task2.collections;

import by.aston.task2.interfaces.IList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T extends Comparable<T>> implements IList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Class<T> type;
    private static int FIRST_AVAILABLE_INDEX = 0;
    private int size = 0;
    private Object[] array;
    private static boolean COLLECTION_SORTED = false;

    public MyArrayList(Class<T> type) {
        this.type = type;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(Collection<? extends T> c, Class<T> type) {
        this.type = type;
        this.array = c.toArray();
        this.size = c.size();
        FIRST_AVAILABLE_INDEX = c.size();
    }

    @Override
    public boolean add(T element) {
        if (FIRST_AVAILABLE_INDEX == size && size != 0) {
            this.array = Arrays.copyOf(this.array, size * 2);
        }
        this.array[FIRST_AVAILABLE_INDEX] = element;
        FIRST_AVAILABLE_INDEX++;
        size++;
        COLLECTION_SORTED = false;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> collection) {
        Object[] newArray = collection.toArray();
        if (newArray.length == 0) {
            return false;
        }
        int s = this.size;
        if (FIRST_AVAILABLE_INDEX == size - 1 || newArray.length > size - FIRST_AVAILABLE_INDEX + 1) {
            this.array = Arrays.copyOf(this.array, size + newArray.length * 2);
            this.size = this.size + newArray.length;
        }
        for (int i = 0; i < newArray.length; i++) {
            this.array[i + s] = newArray[i];
            FIRST_AVAILABLE_INDEX++;
        }
        COLLECTION_SORTED = false;
        return true;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return type.cast(array[index]);
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= array.length) {
            return false;
        }

        Object[] newArr = (Object[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        System.arraycopy(array, 0, newArr, 0, index);
        System.arraycopy(array, index + 1, newArr, index, array.length - index - 1);

        this.array = newArr;
        size--;
        FIRST_AVAILABLE_INDEX--;
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
        Object temp;
        for (int i = 0; i < this.size; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if (comparator.compare(type.cast(this.array[i]), type.cast(this.array[j])) >= 0) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
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

        for (int i = 0; i < size - 1; i++) {
            if ((type.cast(array[i])).compareTo(type.cast(array[i + 1])) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (i + 1 != this.size) {
                builder.append(array[i]).append(" -> ");
            } else {
                builder.append(array[i]);
            }
        }
        return builder.toString();
    }
}
