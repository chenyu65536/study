package com.rain.leetcode.medium;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1], k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3], k = 3
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// -1000 <= nums[i] <= 1000
// -10⁷ <= k <= 10⁷
//
//
// Related Topics 数组 哈希表 前缀和 👍 2044 👎 0
public class Q560 {

    public int subarraySum(int[] nums, int k) {
        long[] sumNums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumNums[i + 1] = sumNums[i] + nums[i];
        }
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (sumNums[j] - sumNums[i] == k) {
                    rs++;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        Q560 q560 = new Q560();
        int rs = q560.subarraySum(nums, 2);
        System.out.printf("" + rs);
    }
}
