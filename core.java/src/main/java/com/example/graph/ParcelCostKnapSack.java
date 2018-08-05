package com.example.graph;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class ParcelCostKnapSack {

    int[][] parcelArray = {{12, 6}, {11, 6}, {6, 3}, {4, 3}, {15, 5}, {8, 2}, {9, 3}};

    class Parcel {
        int id;
        int weight;
        int cost;

        @Override
        public String toString() {
            return "id: " + id + " , weight: " + weight + " , cost: " + cost;

        }
    }

    public static void main(String[] args) {
        ParcelCostKnapSack parcelCostKnapSack = new ParcelCostKnapSack();

        List parcelList = parcelCostKnapSack.createParcel();

        System.out.println("List prepared: " + parcelList);

        int[] usedWeights = new int[parcelList.size()];

        int maxWeight = parcelCostKnapSack.snapSackInArray(parcelCostKnapSack.getWeightArray(), parcelCostKnapSack.getCostArray(), 10);

       // int maxWeight = parcelCostKnapSack.maxWeightForGivenCostOptimized(parcelCostKnapSack.createParcel(), 10, parcelList.size(), usedWeights);

        //System.out.println(parcelCostKnapSack.maxWeightForGivenCostRecursive(parcelCostKnapSack.createParcel(), 10, parcelList.size()));
        System.out.println(maxWeight);


    }

    public int snapSackInArray(int[] wt, int[] ct, int maxCost) {
        int maxWeight = 0;

        int [][] matrix = new int [wt.length+ 1][maxCost + 1];

        Set<Integer> selectedWeights = new TreeSet<>();

        for (int i = 0 ; i <= wt.length; i ++ ) {
            for (int c = 0 ; c <= maxCost; c ++) {

                if ( i == 0 || c == 0) {
                    matrix [i] [c] = 0;
                } else if ( ct[i -1] <= c) {
                    matrix [i] [c] = selectMax(matrix[i - 1] [c], wt[i - 1] + matrix [i -1 ][c - ct [ i - 1]], selectedWeights, wt[i - 1] );


                } else {
                    matrix [i] [c] = matrix [i -1] [c] ;

                }

                System.out.print(matrix [i] [c] + "   ");

            }
            System.out.println();
        }

        maxWeight = matrix [wt.length] [maxCost];

        //for ( int k1 =0 ; k1 < wt.length+ 1; k1++ ){

            System.out.println("selected weight: " + selectedWeights);
       //}

        return maxWeight;

    }

    public int selectMax(int a, int b, Set<Integer> selectedWeights, int weight) {
        int max = 0;
        if ( a > b) {
            max = a ;
        } else {
            max = b;
            selectedWeights.add(weight);
        }

        return max;

    }

    public List<Parcel> createParcel() {

        List<Parcel> parcelList = new ArrayList<>();

        for (int i = 0; i < parcelArray.length; i++) {
            Parcel parcel = new Parcel();
            parcel.id = i;
            parcel.weight = parcelArray[i][0];
            parcel.cost = parcelArray[i][1];

            parcelList.add(parcel);
        }


        return parcelList;

    }

    public int[] getCostArray() {
        int [] costArray = new int [parcelArray.length] ;

        for ( int i = 0 ; i < parcelArray.length ; i ++ ) {
            costArray[i] = parcelArray[i][1];
        }

        return costArray;

    }

    public int[] getWeightArray() {
        int [] weightArray = new int [parcelArray.length] ;

        for ( int i = 0 ; i < parcelArray.length ; i ++ ) {
            weightArray[i] = parcelArray[i][0];
        }

        return weightArray;
    }

    public int maxWeightForGivenCostOptimized(List<Parcel> parcelList, int maxCost, int size, int[] usedWeights) {
        int i, c;
        String weightIncluded = null;
        int k[][] = new int[size + 1][maxCost + 1];

        int[] u1 = new int [usedWeights.length];

        System.arraycopy(usedWeights, 0, u1, 0, u1.length);
        int[] u2 = new int [usedWeights.length];

        System.arraycopy(usedWeights, 0, u2, 0, u2.length);


        for (i = 0; i <= size; i++) {
            for (c = 0; c <= maxCost; c++) {
                if (i == 0 || c == 0) {
                    k[i][c] = 0;
                } else if (parcelList.get(i - 1).cost <= c) {
                    k[i][c] = selectMax(parcelList.get(i - 1).weight + k[i - 1][c - parcelList.get(i - 1).cost],
                            k[i - 1][c]);
                } else {
                    k[i][c] = k[i - 1][c];
                }
            }


        }
        System.out.println("wights included " + weightIncluded);

        return k[size][maxCost];
    }

    //TODO - improve this implementation
    public int maxWeightForGivenCostRecursive(List<Parcel> parcelList, int maxCost, int size) {
        int maxWeight = 0;
        int totalCost = 0;

        if (size == 0 || maxCost == 0) {
            return 0;
        }

        if (parcelList.get(size - 1).cost > maxCost) {
            return maxWeightForGivenCostRecursive(parcelList, maxCost, size - 1);
        } else {
            return selectMax(parcelList.get(size - 1).weight +
                            maxWeightForGivenCostRecursive(parcelList, (maxCost - parcelList.get(size - 1).cost), size - 1),
                    maxWeightForGivenCostRecursive(parcelList, maxCost, size - 1)
            );
        }


       /* for (int i = 0; i < parcelList.size(); i++) {
            int cost = parcelList.get(i).cost;
            int weight = parcelList.get(i).cost;

            if (totalCost >= 10) {
                break;
            }

            maxWeight += p.weight;
        }

        return maxWeight;*/
    }

    public int selectMax(int a, int b) {
        return a > b ? a : b;

    }


}
