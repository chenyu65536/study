package com.rain.leetcode.medium;

public class Q807 {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;

        int[] rowMax = new int[length];//每行最大值
        int[] colMax = new int[length];//每列最大值
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                rowMax[j] = Math.max(rowMax[j],grid[i][j]);
                colMax[i] = Math.max(colMax[i],grid[i][j]);
            }
        }

        int res = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                res += Math.min(rowMax[j],colMax[i])-grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
       // [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
        maxIncreaseKeepingSkyline(new int[][] {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}}
        );
    }
}
