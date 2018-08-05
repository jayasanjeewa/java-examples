package com.example.graph;

import java.util.Set;
import java.util.TreeSet;

public class ParcelWeightDouble {
    int[][] parcelArray = {{12, 6}, {11, 6}, {6, 3}, {4, 3}, {15, 5}, {8, 2}, {9, 3}};

    public static void main(String[] args) {
        ParcelWeightDouble parcelWeight = new ParcelWeightDouble();

        int MAX_COST = 10;

        int maxWeight = parcelWeight.snapSackInArray(parcelWeight.getWeightArray(), parcelWeight.getCostArray(), MAX_COST);

        System.out.println("max weight for the given cost: " + maxWeight);
    }

    public int snapSackInArray(int[] wt, int[] ct, int maxCost) {
        int maxWeight = 0;

        int[][] matrix = new int[wt.length + 1][maxCost + 1];

        // indicates whether the item i is included in cacluating the weight of the matrix[i][w] entry.
        boolean[][] included = new boolean[wt.length+1][maxCost+1];


        for (int i = 0; i <= wt.length; i++) {
            for (int c = 0; c <= maxCost; c++) {

                if (i == 0 || c == 0) {
                    matrix[i][c] = 0;
                } else if (ct[i - 1] <= c) {
                    matrix[i][c] = selectMax(matrix[i - 1][c], wt[i - 1] + matrix[i - 1][c - ct[i - 1]]);
                    included[i][c] = true;

                } else {
                    matrix[i][c] = matrix[i - 1][c];
                    included[i][c] = false;
                }
                //System.out.print(matrix[i][c] + "   ");

            }
            //System.out.println();
        }

        maxWeight = matrix[wt.length][maxCost];

        // now backtrack from [wt.length, maxCost] which of the items are included in there.
        Set<Integer> selectedWeights = new TreeSet<>();
        int c = maxCost;
        for (int i = wt.length; i > 0; i --)  {
            if (included[i][c]) {
                // i-1th element is included to calculate this entry.
                selectedWeights.add(wt[i-1]);
                c = c - ct[i-1];
            }
        }

        // Not working correctly
        System.out.println("selected weight: " + selectedWeights);

        return maxWeight;

    }

    public int selectMax(int a, int b) {
        int max = 0;
        if (a > b) {
            max = a;
        } else {
            max = b;
            // trying get used weights but not working

        }

        return max;

    }

    public int[] getCostArray() {
        int[] costArray = new int[parcelArray.length];

        for (int i = 0; i < parcelArray.length; i++) {
            costArray[i] = parcelArray[i][1];
        }

        return costArray;

    }

    public int[] getWeightArray() {
        int[] weightArray = new int[parcelArray.length];

        for (int i = 0; i < parcelArray.length; i++) {
            weightArray[i] = parcelArray[i][0];
        }

        return weightArray;
    }

}

