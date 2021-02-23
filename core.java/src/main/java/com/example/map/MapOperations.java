package com.example.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapOperations {

    public static void main(String[] args) {

        MapOperations mapOperations = new MapOperations();

        int [] intValues = {2,4,5,7,3, 7};

        Map mapReturned = mapOperations.createHashMap(intValues);

        System.out.println("before sort: "+ mapReturned);

        mapReturned = mapOperations.sortMap(mapReturned);

        System.out.println("after sort: "+ mapReturned);

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

    public Map sortMap(Map map) {
       var sortedMap = new HashMap<>() ;

      // map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
              // Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new)
       //);

       return new LinkedHashMap(map);
    }

}
