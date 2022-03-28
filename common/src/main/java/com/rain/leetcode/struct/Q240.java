package com.rain.leetcode.struct;
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
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
// 1 <= n, m <= 300
// -10⁹ <= matrix[i][j] <= 10⁹
// 每行的所有元素从左到右升序排列
// 每列的所有元素从上到下升序排列
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 分治 矩阵 👍 966 👎 0

public class Q240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //[1 ,4, 7, 11,15],
        //[2 ,5, 8, 12,19],
        //[3 ,6, 9, 16,22],
        //[10,13,14,17,24],
        //[18,21,23,26,30]
        //大于前一行最大值 [][matrix[i].length-1]
        //小于后一行最小值 [x][0]
        int startRow = 0;
        int endRow = matrix.length - 1;

        //缩小行
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][matrix[0].length - 1]) {
                startRow = i + 1;
            } else {
                break;
            }
        }
        for (int i = startRow; i < matrix.length; i++) {
            if (target < matrix[i][0]) {
                endRow = i - 1;
                break;
            }
        }
        for (int i = startRow; i <=endRow; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       // nums = new int[][] {{-1,3}};

        Q240 q240 = new Q240();
        boolean rs = q240.searchMatrix(nums,20);
        System.out.printf("11"+rs);
    }
}
