package com.rain.leetcode.medium;

import java.util.LinkedList;

public class Q994 {
    public static int orangesRotting(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] vis = new boolean[height + 2][width + 2];
        LinkedList<int[]> list = new LinkedList<>();
        int[][] newGrid = new int[height + 2][width + 2];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newGrid[i + 1][j + 1] = grid[i][j];
                if (grid[i][j] == 2) {
                    list.add(new int[]{i + 1, j + 1});
                    vis[i + 1][j + 1] = true;
                }
            }
        }
        int times = -1;
        while (!list.isEmpty()) {
            LinkedList<int[]> swaplist = list;
            list = new LinkedList<>();
            times++;
            while (!swaplist.isEmpty()) {
                int[] pos = swaplist.pop();
                int i = pos[0];
                int j = pos[1];
                if (!vis[i][j - 1] && newGrid[i][j - 1] == 1) {
                    // newGrid[i][j - 1] = 2;
                    vis[i][j - 1] = true;
                    list.add(new int[]{i, j - 1});
                }
                if (!vis[i][j + 1] && newGrid[i][j + 1] == 1) {
                    //newGrid[i][j + 1] = 2;
                    vis[i][j + 1] = true;
                    list.add(new int[]{i, j + 1});
                }
                if (!vis[i - 1][j] && newGrid[i - 1][j] == 1) {
                    //newGrid[i - 1][j] = 2;
                    vis[i - 1][j] = true;
                    list.add(new int[]{i - 1, j});

                }
                if (!vis[i + 1][j] && newGrid[i + 1][j] == 1) {
                    //newGrid[i + 1][j] = 2;
                    vis[i + 1][j] = true;
                    list.add(new int[]{i + 1, j});
                }
            }
        }

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (!vis[i][j] && newGrid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(times, 0);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        grid = new int[][]{
                {0},
                {1}
        };
        int rs = orangesRotting(grid);
        System.out.printf("" + rs);

    }
}
