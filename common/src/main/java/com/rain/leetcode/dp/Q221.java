package com.rain.leetcode.dp;
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 数组 动态规划 矩阵 👍 1034 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q221 {

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[][] height = new int[matrix.length][matrix[0].length];

        int maxLength = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            height[0][i] = matrix[0][i] - '0';
            maxLength = Math.max(maxLength, dp[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLength = Math.max(maxLength, dp[i][0]);
        }


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                height[j][i] = matrix[j][i] > '0' ? height[j - 1][i] + 1 : 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            int currentLength = matrix[i][0]-'0';
            for (int j = 1; j < matrix[0].length; j++) {
                int length = matrix[i][j] == '0' ? 0 : Math.min(dp[i - 1][j - 1], Math.min(currentLength, height[i - 1][j])) + 1;
                dp[i][j] = length;
                maxLength = Math.max(maxLength, length);
                currentLength = (matrix[i][j] == '0') ? 0 : currentLength + 1;
            }
        }
        return maxLength * maxLength;
    }


    public static void main(String[] args) {
//输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1']
//,["1","0","0","1","0"]]
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        };

        matrix = new char[][]{
                {'0', '1'},
                {'1', '0'},
        };

        matrix = new char[][]{
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'},
        };
        //  [],[],[],[],[]

        Q221 q221 = new Q221();

        int rs = q221.maximalSquare(matrix);
        System.out.printf("" + rs);
    }
}
