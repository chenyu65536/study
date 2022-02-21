package com.rain.leetcode.dp;

//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//
//
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
//
//
//
// 示例：
//
//
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
//
//
//
//
// 提示：
//
//
// 你可以假设矩阵不可变。
// 会多次调用 sumRegion 方法。
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
//
// Related Topics 动态规划
// 👍 162 👎 0

public class Q304 {
    int[][] matrix;
    int[][] dp;

    public Q304(int[][] matrix) {
        this.matrix = matrix;
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];

        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == row2 && col1 == col2) {
            return matrix[row1][col1];
        }

        if (row1 > 0 && col1 > 0) {
            return dp[row2][col2] + dp[row1 - 1][col1 - 1] - dp[row1 - 1][col2] - dp[row2][col1 - 1];
        } else if (row1 == 0 && col1 != 0) {
            return dp[row2][col2] - dp[row2][col1 - 1];
        } else if (row1 != 0 && col1 == 0) {
            return dp[row2][col2] - dp[row1 - 1][col2];
        } else {
            return dp[row2][col2];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };

        matrix = new int[][]{
                {-4, -5},
        };

        Q304 q304 = new Q304(matrix);
        int rs = q304.sumRegion(0, 0, 0, 1);
        System.out.printf("" + rs);

        //   测试结果:[null, -4, -5, -1]期望结果:[null, -4, -9, -5]
    }
}
