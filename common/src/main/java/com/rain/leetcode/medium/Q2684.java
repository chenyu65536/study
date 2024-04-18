package com.rain.leetcode.medium;

public class Q2684 {

    public static int maxMoves(int[][] grid) {
        boolean[][] steps = new boolean[grid.length + 2][grid[0].length];
        for(int j = 0; j < steps[0].length; j++){
            steps[j][0] = true;
        }


        int maxStep = 0;
        for (int j = 1; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length-1; i++) {
                int min = Integer.MAX_VALUE;
                if ((steps[i - 1][j - 1] && grid[i][j] > grid[i - 1][j - 1]) ||
                        (steps[i][j - 1] && grid[i][j] > grid[i][j - 1]) ||
                        (steps[i + 1][j - 1] && grid[i][j] > grid[i + 1][j - 1])) {
                    steps[i + 1][j] = true;
                }
                if (min != Integer.MAX_VALUE) {
                    maxStep = Math.max(j,maxStep);
                }
            }
        }
        return maxStep;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,4,3,5},
                {5,4,9,3},
                {3,4,2,11},
                {10,9,13,15}
        };
        grid = new int[][]{
                {3,2,4},
                {2,1,9},
                {1,1,7}
        };
        grid = new int[][]{
                {187, 167, 209, 251, 152, 236, 263, 128, 135},
                {267, 249, 251, 285, 73,  204, 70,  207, 74},
                {189, 159, 235, 66,  84,  89,  153, 111, 189},
                {120, 81,  210, 7,   2,   231, 92,  128, 218},
                {193, 131, 244, 293, 284, 175, 226, 205, 245}
        };
        int rs = Q2684.maxMoves(grid);
        System.out.printf(""+rs);
    }


}
