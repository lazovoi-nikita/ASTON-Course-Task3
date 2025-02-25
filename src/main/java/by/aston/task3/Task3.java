package by.aston.task3;

import by.aston.task2.interfaces.IList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        build();
    }

    public static void build() {
        System.out.println("--Static sorting--");
        List<Integer> collection = new ArrayList<>(Arrays.asList(3, 1, 2, 5, 4));
        System.out.println("Before sorting: " + collection);
        IList.sort(collection);
        System.out.println("After sorting: " + collection);
    }
}
