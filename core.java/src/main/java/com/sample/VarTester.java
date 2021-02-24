package com.sample;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;

public class VarTester {
    public static void main(String [] args) {
        var movies = new HashMap<String, String>();
        movies.put("mv1", "Good");

        for (var entry : movies.entrySet() ) {
            System.out.println(entry.getKey() + " : " + entry.getValue() );
        }

        var s = "";
        System.out.println(s.isBlank());
        //s = 12;
    }
}
