package com.rain.leetcode.medium;

public class Q2684 {

    public static int maxMoves(int[][] grid) {
        boolean[][] canReached = new boolean[grid.length + 2][grid[0].length];
        int[][] newGrid = new int[grid.length + 2][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            newGrid[0][i] = Integer.MAX_VALUE;
            newGrid[newGrid.length - 1][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i + 1][j] = grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            canReached[i + 1][0] = true;
        }


        int distance = 0;
        for (int i = 1; i < newGrid[0].length; i++) {
            for (int j = 1; j < newGrid.length - 1; j++) {
                if ((canReached[j - 1][i - 1] && newGrid[j][i] > newGrid[j - 1][i - 1]) ||
                        (canReached[j][i - 1] && newGrid[j][i] > newGrid[j][i - 1]) ||
                        (canReached[j + 1][i - 1] && newGrid[j][i] > newGrid[j + 1][i - 1])
                ) {
                    canReached[j][i] = true;
                    distance = Math.max(distance, i);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        //[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
        int[][] grid = new int[][]{
                {2,4,3,5},
                {5,4,9,3},
                {3,4,2,11},
                {10,9,13,15},
        };
        int rs = Q2684.maxMoves(grid);
        System.out.printf(""+rs);
    }
}
