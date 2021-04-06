package com.rain.leetcode.medium;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
// 👍 363 👎 0

public class Q74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        //二分查找
        int height = matrix.length;
        int width = matrix[0].length;

        if (matrix[0][0] > target || target > matrix[height - 1][width - 1]) {
            return false;
        }else if(matrix[0][0] == target || target == matrix[height - 1][width - 1]){
            return true;
        }

        int total = height * width;

        int startIndex = 1;
        int endIndex = total;
        while (endIndex > startIndex) {
            int[] midIndex = getMidIndex(startIndex, endIndex, width);
            if (matrix[midIndex[0]][midIndex[1]] == target) {
                return true;
            }
            int midPosition = midIndex[0] * width + midIndex[1] + 1;
            if (midPosition == startIndex) {
                return false;
            }
            if (matrix[midIndex[0]][midIndex[1]] > target) {
                endIndex = midPosition;
            } else {
                startIndex = midPosition;
            }
        }
        return false;
    }

    private int[] getMidIndex(int startPosition, int endPosition, int width) {
        int midPosition = startPosition + (endPosition - startPosition) / 2;
        int m = midPosition % width == 0 ? midPosition / width - 1 : midPosition / width;
        int n = midPosition % width == 0 ? width - 1 : midPosition % width - 1;
        return new int[]{m, n};
    }


    public static void main(String[] args) {
        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
         int[][] a = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //int[][] a = new int[][]{{1}};
        Q74 q74 = new Q74();
        boolean result = q74.searchMatrix(a, 21);
        System.out.printf("" + result);
    }

}
