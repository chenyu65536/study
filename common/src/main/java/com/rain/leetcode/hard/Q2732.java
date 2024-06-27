package com.rain.leetcode.hard;

import java.util.*;

public class Q2732 {
    int[][] grid;
    /**
     [
     [1,0,0,1,0],
     [1,0,1,0,1],
     [0,0,0,0,1],
     [1,0,1,1,1]
     ]

     */
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        this.grid = grid;
        int width = grid[0].length,heigth =grid.length;
        Map<Integer,Integer> sumMap = new HashMap<>();
        for (int i = 0; i < heigth; i++) {
            int sum = 0;
            for (int j = 0; j < width; j++) {
                sum+=grid[i][j];
            }
            if(sum==0){
                return Arrays.asList(i);
            }
            sumMap.put(i,sum);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                if (sumMap.get(i)+sumMap.get(j)<=width && check(i,j)) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean check(int row1,int row2) {
        for (int i = 0; i < grid[0].length; i++) {
            if((grid[row1][i]&grid[row2][i])==1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q2732 q2732  = new Q2732();
        q2732.goodSubsetofBinaryMatrix(new int[][]
                {
                        {1,0,0,1,0},
                        {1,0,1,0,1},
                        {0,0,0,0,1},
                        {1,0,1,1,1}}
        );

    }
}
