package com.rain.leetcode.medium;


public class Q377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        Q377 q377 = new Q377();
        int[] nums = new int[]{2, 1, 3};
        int rs = q377.combinationSum4(nums, 4);
        System.out.println("" + rs);
    }
}
