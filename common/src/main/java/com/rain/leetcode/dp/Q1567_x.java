package com.rain.leetcode.dp;
//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
//
// 请你返回乘积为正数的最长子数组长度。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
//
//
//
// Related Topics 贪心 数组 动态规划 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q1567_x {
    public int getMaxLen(int[] nums) {
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];

        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLength = positive[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLength = Math.max(maxLength,positive[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2};
        Q1567_x q1567X = new Q1567_x();
        int rs = q1567X.getMaxLen(nums);
        System.out.printf("" + rs);
    }

}
