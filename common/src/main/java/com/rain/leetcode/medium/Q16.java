package com.rain.leetcode.medium;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针




public class Q16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int m = i + 1; m < nums.length; m++) {
                for (int n = m + 1; n < nums.length; n++) {
                    int tempSum = nums[i] + nums[m] + nums[n];
                    if (Math.abs(target - sum) > Math.abs(target - tempSum)) {
                        sum = tempSum;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Q16 q16 = new Q16();
        int[] nums = new int[]{-1,2,1,-4,0};
        System.out.printf(""+q16.threeSumClosest(nums,1));
    }
}
