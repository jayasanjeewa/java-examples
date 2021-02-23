package com.example.graph;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrimitiveTest {
    public static void main(String[] args) {
       long l = 10;
       l = l + 1;
        System.out.println(l);

        List list = List.of(1,6,8,8,11,11);

        System.out.println(list);

        Set set = new LinkedHashSet(list);

        List list2 = new ArrayList<>(set);

        System.out.println(list2);

        Collections.reverse(list2);

        Collections.sort(list2);

        System.out.println(list2);

        Comparator com = Collections.reverseOrder();
        Collections.sort(list2, com);

        System.out.println(list2);

        List list3 = Collections.unmodifiableList(list2);

        List list4 = new CopyOnWriteArrayList(list2);

        System.out.println(list4);

        //list3.add(1);


    }
}
