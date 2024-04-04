package com.rain.leetcode.medium;
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 1865 👎 0

import java.util.ArrayList;
import java.util.List;

//TODO 23/08/30
public class Q416_X {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        boolean rs = backTrack(nums, 0, target, 0);
        return rs;
    }

    List<Integer> used = new ArrayList<>();

    public boolean backTrack(int[] nums, int preSum, int target, int startIndex) {
        if (preSum == target) {
            return true;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            preSum += nums[i];
            if (preSum > target) {
                used.remove(used.size() - 1);
                preSum -= nums[i];
            }
            boolean rs = backTrack(nums, preSum, target, i + 1);
            if(rs){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //输入：nums = [1,5,11,5]
        //输出：true
        //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Q416_X q416 = new Q416_X();
        boolean rs = q416.canPartition(nums);
        System.out.printf("__" + rs);
    }

}
