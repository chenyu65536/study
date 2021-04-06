package com.rain.leetcode.medium;

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

import com.rain.leetcode.easy.Q303;

public class Q304_x {

    private int[][] sum;

    public Q304_x(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sum = new int[matrix.length][matrix[0].length+1];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            if (i >= matrix[0].length) {
                sum[0][i] = sum[0][i - 1];
            } else {
                sum[0][i] = sum[0][i - 1] + matrix[0][i];
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sum[row2][col2]
                - (col1 == 0 ? 0 : sum[row2][col1 - 1])
                - (row1 == 0 ? 0 : sum[row1 - 1][col2])
                + (row1 == 0 || col1 == 0 ? 0 : sum[row1 - 1][col1 - 1]);
    }

    public static void main(String[] args) {
     /*   ["NumMatrix","sumRegion","sumRegion","sumRegion"]
        Q304 q304  = new Q304(new int[][]{[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]})
        [2,1,4,3],[1,1,2,2],[1,2,2,4]]
        测试结果:[null,4,0,6] 期望结果:[null,8,11,12]*/


        int[] a[] = {{-4, -5}, {0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 1}};

        //int[] a[] = {{3, 0, 1}, {5, 6, 3}, {1, 2, 0}};

        Q304_x q304 = new Q304_x(a);

        //  System.out.println(""+ q304.sumRegion(2, 2, 3, 3));


        System.out.println("" + q304.sumRegion(2, 1, 3, 3));
        //System.out.println("" + q304.sumRegion(0, 0, 1, 1));
        // System.out.println("" + q304.sumRegion(1, 2, 2, 4));

    }
}
