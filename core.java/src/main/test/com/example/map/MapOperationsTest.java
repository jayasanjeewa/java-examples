package com.example.map;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class MapOperationsTest {

     MapOperations target  = new MapOperations();;

    @BeforeEach
     void before() {
    target = new MapOperations();
    }

    @Test
     void createTreeMap() {
    }

    @Test
     void createHashMap() {
    }

    @Test
     void sortMap() {
        Map map = target.createHashMap(new int [] {1, 2,  5, 6});

        Map sortedMap = target.sortMap(map);

        assertEquals(map.size(), sortedMap.size(), "Not  Equal");

        assertThat(map.size(), equalTo(sortedMap.size()));

    }
}