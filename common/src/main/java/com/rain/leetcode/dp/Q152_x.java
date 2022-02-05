package com.rain.leetcode.dp;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划 👍 1462 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q152_x {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int rs = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int imax = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * imax, nums[i] * min));
            rs = Math.max(rs, max);
        }
        return rs;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, -5, -2, -4, 3};
        Q152_x q152X = new Q152_x();
        int rs = q152X.maxProduct(nums);
        System.out.printf("" + rs);

    }

}
