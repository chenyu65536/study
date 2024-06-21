package com.rain.leetcode.medium;

public class Q3071 {

    public int minimumOperationsToWriteY(int[][] grid) {
        int len = grid.length;
        int[] yValueCount = new int[3];//0,1,2
        int[] otherValueCount = new int[3];//0,1,2

        for (int i = 0; i < len; i++) {
            if (i < len / 2) {
                yValueCount[grid[i][i]]++;
                yValueCount[grid[i][len - i - 1]]++;
            } else {
                yValueCount[grid[i][len / 2]]++;
            }
            //(i,i),(len-i-1,i)// i<=len/2
            for (int j = 0; j < len; j++) {
                otherValueCount[grid[i][j]]++;
            }
        }
        otherValueCount[0] -= yValueCount[0];
        otherValueCount[1] -= yValueCount[1];
        otherValueCount[2] -= yValueCount[2];

        //y->0
        int y0 = yValueCount[1] + yValueCount[2];
        int o0 = Math.min(otherValueCount[1], otherValueCount[2]) + otherValueCount[0];

        int y1 = yValueCount[0] + yValueCount[2];
        int o1 = Math.min(otherValueCount[0], otherValueCount[2]) + otherValueCount[1];


        int y2 = yValueCount[0] + yValueCount[1];
        int o2 = Math.min(otherValueCount[0], otherValueCount[1]) + otherValueCount[2];

        return Math.min(Math.min(y0 + o0, y1 + o1), y2 + o2);
    }

    public static void main(String[] args) {
        Q3071 q3071 = new Q3071();
        int[][] grid = new int[][]{
                {1, 2, 2},
                {1, 1, 0},
                {0, 1, 0}
        };
       int rs =  q3071.minimumOperationsToWriteY(grid);
        System.out.printf("");
    }
}
