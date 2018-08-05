package com.example.algo;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PanargamChecker {
    public static void main(String[] args) {

        PanargamChecker panargamChecker = new PanargamChecker();

        System.out.println(panargamChecker.checkPanagram("Fox nymphs grab quick-jived waltz."));
    }

    private String checkPanagram(String s) {
        char [] charArray = s.toLowerCase().replace(" ", "").toCharArray();

        Set<Character> allCharSet = new TreeSet<>();
        Set<Character> orderedSet = new LinkedHashSet<>();

        char [] allChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c : allChars) {
            allCharSet.add(c);
        }

        for (char c : charArray) {
            /*if (charArray[i]) == ' ') {

            }*/

            if ( c > 96 && c < 123 ) {
                orderedSet.add(c);
                allCharSet.remove(c);
            }

        }

        if (orderedSet.size() == 26) {
           return null;
        } else {
            return allCharSet.toString();
        }



    }
}
