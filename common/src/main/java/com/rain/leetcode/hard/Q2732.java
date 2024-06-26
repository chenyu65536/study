package com.rain.leetcode.hard;

import java.util.*;

public class Q2732 {

    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int width = grid[0].length, height = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < height; i++) {
            int val = 0;
            for (int j = 0; j < width; j++) {
                val = (val << 1 | grid[i][j]);
            }
            if (val == 0) {
                return List.of(i);
            }
            map.put(val, i);
        }
        for (int key1 : map.keySet()) {
            for (int key2 : map.keySet()) {
                if ((key1 & key2) == 0) {
                    int i = map.get(key1);
                    int j = map.get(key2);
                    return i < j ? List.of(i, j) : List.of(j, i);
                }
            }
        }
        return List.of();
    }

    public static void main(String[] args) {
        Q2732 q2732 = new Q2732();
     /*   List<Integer> rs = q2732.goodSubsetofBinaryMatrix(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 1},
        });*/

        List<Integer> rs = q2732.goodSubsetofBinaryMatrix(new int[][]{
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0}
        });
    }
}
