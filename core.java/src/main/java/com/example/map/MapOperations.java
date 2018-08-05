package com.example.map;

import java.util.*;

public class MapOperations {

    public static void main(String[] args) {

        MapOperations mapOperations = new MapOperations();

        int [] intValues = {2,4,5,7,3, 7};

        Map mapReturned = mapOperations.createHashMap(intValues);

        mapReturned = Collections.synchronizedMap(mapReturned);

        Set<Map.Entry> set = mapReturned.entrySet();

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key: "+ entry.getKey() + " and value: "+ entry.getValue());
        }

        /*for (Map.Entry entry : set ) {
            System.out.println("key: "+ entry.getKey() + " and value: "+ entry.getValue());
        }*/

    }

    public Map<Integer, String> createTreeMap (int [] keys) {
        Map<Integer, String> map  = new TreeMap();

        for (int key : keys) {
            map.put(key, "Value"+ key);
        }

        return map;
    }

    public Map<Integer, String> createHashMap (int [] keys) {
        Map<Integer, String> map  = new HashMap<>();
Random random = new Random(52);

        for (int key : keys) {
            map.put(key, "Value"+ random.nextInt());
        }

        return map;
    }

}
