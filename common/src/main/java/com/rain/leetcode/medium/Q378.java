package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        //i+j<=k
        int bound = Math.min(k, matrix.length);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound && i + j < k; j++) {
                nums.add(matrix[i][j]);
            }
        }
        nums.sort((a, b) -> a - b);
        return nums.get(k - 1);
    }

    public static void main(String[] args) {
        Q378 q378 = new Q378();
        //int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(q378.kthSmallest(matrix, k));
    }
}
