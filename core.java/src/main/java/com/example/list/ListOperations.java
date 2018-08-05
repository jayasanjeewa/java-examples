package com.example.list;

import java.util.*;

public class ListOperations<T> {
    public static void main(String[] args) {

        ListOperations<Integer> listOperations = new ListOperations<>();

        List<Integer> unsortedList = Arrays.asList(1, 4, 7, 5, 3, 2, 6, 6);
        System.out.println("list values: " + unsortedList);
       // listOperations.sortList(unsortedList);

       // System.out.println("list values: " + unsortedList);
        System.out.println("set values: " + new ArrayList<Integer>(listOperations.listToSet(unsortedList)));
    }

    public void sortList(List<Integer> unsortedList) {
        Collections.sort(unsortedList, (a, b) -> { return ((a < b)  ? 1 : (a == b ? 0 : -1)); } );
    }

    public Set listToSet(List<Integer> unsortedList) {
        Set<Integer> unsortedSet = new TreeSet(unsortedList);

        return unsortedSet;
    }

}
