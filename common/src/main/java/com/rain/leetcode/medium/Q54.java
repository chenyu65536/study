package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组
// 👍 652 👎 0
public class Q54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        int times = (int) Math.ceil((float)Math.min(matrix.length, matrix[0].length)/2);
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            addRow(matrix, i, data);
        }
        return data;
    }

    public static void addRow(int[][] matrix, int level, List<Integer> data) {
        int high = matrix.length - 2 * level;
        int with = matrix[level].length - 2 * level;

        //append top row
        for (int i = level; i < matrix[level].length - level; i++) {
            data.add(matrix[level][i]);
        }

        if (high < 2) {
            return;
        }
        //append right column
        for (int j = level + 1; j < matrix.length - level - 1; j++) {
            data.add(matrix[j][matrix[level].length - level - 1]);
        }

        //append bottom row
        for (int i = matrix[level].length - level - 1; i >= level; i--) {
            data.add(matrix[matrix.length - level - 1][i]);
        }

        if (with < 2) {
            return;
        }
        //append left column
        for (int j = matrix.length - level - 2; j > level; j--) {
            data.add(matrix[j][level]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}, {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}};
        List<Integer> data = spiralOrder(matrix);
        System.out.printf("" + data.toString());
    }
}
