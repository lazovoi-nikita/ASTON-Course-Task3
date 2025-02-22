package by.aston.task1;

import by.aston.task1.collections.ArrayListCollection;
import by.aston.task1.collections.GenericList;
import by.aston.task1.collections.LinkedListCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        build();
    }

    public static void build() {
        GenericList<Integer> arrayList = new ArrayListCollection<>();
        GenericList<Integer> linkedList = new LinkedListCollection<>();
        Map<String, Integer> hashMap = new HashMap<>();

        //ArrayList
        arrayList.addFirst(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("ArrayList: " + arrayList.getList());
        arrayList.addFirst(0);
        arrayList.addLast(11);
        arrayList.addLast(Arrays.asList(12, 13, 14));
        arrayList.addCenter(100);
        arrayList.addCenter(Arrays.asList(101, 102));
        System.out.println("ArrayList after added elements: " + arrayList.getList());
        arrayList.remove(Arrays.asList(101, 102));
        arrayList.remove(14);
        System.out.println("ArrayList after removed elements: " + arrayList.getList());
        System.out.println("-----------------------------");

        //LikedList
        linkedList.addFirst(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("LinkedList: " + linkedList.getList());
        linkedList.addFirst(0);
        linkedList.addLast(11);
        linkedList.addLast(List.of(12, 13, 14));
        linkedList.addCenter(100);
        linkedList.addCenter(List.of(101, 102));
        System.out.println("LinkedList after added elements: " + linkedList.getList());
        linkedList.remove(Arrays.asList(101, 102));
        linkedList.remove(14);
        System.out.println("LinkedList after removed elements: " + linkedList.getList());
        System.out.println("-----------------------------");

        //HashMap
        for (int i = 0; i <= 10; i++) {
            hashMap.put(String.valueOf(i), i);
        }
        System.out.println("HashMap: " + hashMap);
        hashMap.put("0", 0);
        hashMap.put("11", 11);
        hashMap.put("100", 100);
        System.out.println("HashMap after added elements: " + hashMap);
        hashMap.remove("100");
        System.out.println("HashMap after removed elements: " + hashMap);
        System.out.println("-----------------------------");
    }
}
