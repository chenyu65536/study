package com.rain.leetcode.dp;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划 👍 2237 👎 0


public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int rs = 1;
        dp[0][0] = nums[0];
        dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = nums[i];
            int j = i;
            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[j][1], dp[i][1]);
                }
                j--;
            }
            dp[i][1] = dp[i][1] + 1;
            rs = Math.max(rs, dp[i][1]);
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Q300 q300 = new Q300();
        int length = q300.lengthOfLIS(nums);
        System.out.printf("" + length);
    }
}
