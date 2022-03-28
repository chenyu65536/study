package com.rain.leetcode.math;
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//
//
// 示例 1:
//
//
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
//
//
// 示例 2:
//
//
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// -30 <= nums[i] <= 30
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
//
//
//
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组 前缀和 👍 1106 👎 0

public class Q238 {

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        left[0] = nums[0];

        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] rs = new int[nums.length];
        rs[0] = right[1];
        for (int i = 1; i < nums.length - 1; i++) {
            rs[i] = left[i - 1] * right[i + 1];
            left[i] = left[i - 1] * nums[i];
        }
        rs[nums.length - 1] = left[nums.length - 2];
        return rs;
    }

    public static void main(String[] args) {
        //
        int[] nums = new int[]{1,2,3,4};
        //输出: [24,12,8,6]
        Q238 q238 = new Q238();
        int[] rs = q238.productExceptSelf(nums);
        System.out.printf("11");
    }


}
