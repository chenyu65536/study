package com.rain.leetcode.dp;
//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。
//
//
//
// 示例 1：
//
//
//
//
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
//
//
// 示例 2：
//
//
//
//
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
//
//
//
//
// 提示：
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵 👍 146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q931 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int min = dp[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < matrix.length) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int rs = dp[matrix.length - 1][0];
        for (int j = 1; j < matrix.length; j++) {
            rs = Math.min(rs, dp[matrix.length - 1][j]);
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{-19,57}, {-40,-5}};
//[-19,57],[-40,-5]
        Q931 q931 = new Q931();
        int rs = q931.minFallingPathSum(m);
        System.out.printf("" + rs);
    }
}
