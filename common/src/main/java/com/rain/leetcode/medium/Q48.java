package com.rain.leetcode.medium;

public class Q48 {

    public static void rotate(int[][] matrix) {
        int length = matrix.length;

        int[][] matrixCopy =  new int[length][length];//matrix.clone();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrixCopy[j][length - i - 1] = matrix[i][j];
                //matrixCopy[j][length - 1 - i] = matrix[i][j];
            }
        }

        System.out.printf("11");
    }


    public static void rotate2(int[][] matrix) {
        int length = matrix.length;

        int[][] matrixCopy = new int[length][length];//matrix;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrixCopy[j][length - i - 1] = matrix[i][j];
                //matrixCopy[j][length - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = matrixCopy[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

       matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//输出：[[7,4,1],[8,5,2],[9,6,3]]
        Q48.rotate(matrix);
        System.out.printf("1");
    }
}
