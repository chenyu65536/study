package com.rain.leetcode.medium;

//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//
//
// 示例 2：
//
//
//输入：nums = [1], target = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 100
//
// Related Topics 深度优先搜索 动态规划
// 👍 725 👎 0
public class Q494 {


    public int findTargetSumWaysV2(int[] nums, int target) {
        if (nums.length == 1) {
            return end(nums, target);
        }

        return count(nums, target - nums[0], 1) + count(nums, target + nums[0], 1);
    }


    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            return end(nums, target);
        }
        return count(nums, target - nums[0], 1) + count(nums, target + nums[0], 1);
    }

    private int count(int[] nums, int target, int startIndex) {
        if (startIndex == nums.length - 1) {
            return end(nums, target);
        }
        return count(nums, target - nums[startIndex], startIndex + 1)
                + count(nums, target + nums[startIndex], startIndex + 1);
    }

    private int end(int[] nums, int target) {
        if (nums[0] == 0 && target == 0) {
            return 2;
        }
        if (nums[0] == target || nums[0] == -target) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Q494 q494 = new Q494();
        int[] nums = new int[]{1, 0};
        int count = q494.findTargetSumWays(nums, 1);
        System.out.printf("" + count);
    }
}
