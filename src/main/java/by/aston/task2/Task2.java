package by.aston.task2;

import by.aston.task2.collections.MyArrayList;
import by.aston.task2.collections.MyLinkedList;
import by.aston.task2.interfaces.IList;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        build();
    }

    public static void build() {
        IList<Integer> arrayList = new MyArrayList<>(Arrays.asList(2, 1, 3, 6, 5, 4), Integer.class);
        IList<Integer> linkedList = new MyLinkedList<>(Arrays.asList(2, 1, 3, 6, 5, 4));
        System.out.println("--My collections--");
        showCollections(arrayList, linkedList);

        System.out.println("--Add one element--");
        System.out.println("Has element 7 been added in arrayList? - " + arrayList.add(7));
        System.out.println("Has element 7 been added in linkedList? - " + linkedList.add(7));
        showCollections(arrayList, linkedList);

        System.out.println("--Add collections--");
        System.out.println("Has element 11, 8, 10, 9 been added in arrayList? - " + arrayList.addAll(Arrays.asList(11, 8, 10, 9)));
        System.out.println("Has element 11, 8, 10, 9 been added in linkedList? - " + linkedList.addAll(List.of(11, 8, 10, 9)));
        showCollections(arrayList, linkedList);

        System.out.println("--Remove element (index 5)--");
        System.out.println("Has element 7 been removed in arrayList? - " + arrayList.remove(5));
        System.out.println("Has element 7 been removed in linkedList? - " + linkedList.remove(5));
        showCollections(arrayList, linkedList);

        System.out.println("--Get element (index 4)--");
        System.out.println("ArrayList: " + arrayList.get(4));
        System.out.println("LinkedList: " + linkedList.get(4));

        System.out.println("--Sort collections--");
        arrayList.sort(Integer::compareTo);
        linkedList.sort(Integer::compareTo);
        showCollections(arrayList, linkedList);
    }

    private static void showCollections(IList<Integer> arrayList, IList<Integer> linkedList) {
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
