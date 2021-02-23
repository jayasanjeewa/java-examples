package com.example.array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayOperations {
    public static void main(String[] args) {

        int [] intArr = new int [5];
        int [] intArr2 = {2,8,4,3,6};



        int found = Arrays.binarySearch(intArr2, 2);

        System.out.println(found);

    }

    public int[] reverseArray(int[] arr) {
        int [] returnArray = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

    return returnArray;
    }
}
