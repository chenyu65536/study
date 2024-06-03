package com.rain.leetcode.medium;

public class LCR013 {
    int[][] matrix;
    int[][] sum;

    public LCR013(int[][] matrix) {
        int width = matrix[0].length, height = matrix.length;
        this.matrix = matrix;
        this.sum = new int[height][width];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < height; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < width; j++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + matrix[i][j] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*if (row1 == 0 || col1 == 0) {
            return sum[row2][col2]
        }*/
        int rs = sum[row2][col2];
        if (row1 > 0) {
            rs -= sum[row1 - 1][col2];
        }
        if (col1 > 0) {
            rs -= sum[row2][col1 - 1];
        }
        if (col1 > 0 && row1 > 0) {
            rs += sum[row1 - 1][col1 - 1];
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        LCR013 lcr013 = new LCR013(matrix);
        int rs = lcr013.sumRegion(1,1,2,2);
        System.out.printf("" + rs);
    }
}
