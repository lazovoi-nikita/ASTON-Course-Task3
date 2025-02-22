package by.aston.task1.collections;

import by.aston.task1.interfaces.ICollection;

import java.util.Collection;
import java.util.List;

public abstract class GenericList<T> implements ICollection<T> {
    private final List<T> list;

    public GenericList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return this.list;
    }

    @Override
    public void addFirst(Collection<T> collection) {
        this.list.addAll(0, collection);
    }

    @Override
    public void addFirst(T element) {
        this.list.addFirst(element);
    }

    @Override
    public void addLast(Collection<T> collection) {
        this.list.addAll(this.list.size(), collection);
    }

    @Override
    public void addLast(T element) {
        this.list.addLast(element);
    }

    @Override
    public void addCenter(Collection<T> collection) {
        this.list.addAll(this.list.size() / 2, collection);
    }

    @Override
    public void addCenter(T element) {
        this.list.add(this.list.size() / 2, element);
    }

    @Override
    public void remove(Collection<T> collection) {
        this.list.removeAll(collection);
    }

    @Override
    public void remove(T item) {
        this.list.remove(item);
    }
}
