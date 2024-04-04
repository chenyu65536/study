package com.rain.leetcode.medium;

public class I1723 {

    public int[] findSquare(int[][] matrix) {
        //查找最大矩形
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] max = new int[3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }

                    if (dp[i][j] > max[2]) {
                        int length = dp[i][j];
                        max = new int[]{i - length + 1, j - length + 1, dp[i][j]};
                    }
                }
            }
        }
        return max[2] == 0 ? new int[]{} : max;
    }

    public static void main(String[] args) {
        //[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
        int[][] matrix = new int[][]
                {{1, 1, 1, 0, 1, 1, 0, 1, 0, 0}, {0, 1, 0, 1, 1, 0, 0, 0, 1, 1}, {0, 0, 1, 1, 0, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}}

        ;
        I1723 i1723 = new I1723();
        i1723.findSquare(matrix);
        System.out.printf("11");
    }
}
