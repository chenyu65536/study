package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q2786 {
    public static long maxScore(int[] nums, int x) {
        List<Integer> list = new ArrayList<>();
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                list.add(total);
                total = 0;
            }
            total += nums[i];
        }
        list.add(total);


        int length = list.size();
        int[][] dp = new int[length][2];
        dp[0][0] = list.get(0);
        dp[0][1] = list.get(0);
        for (int i = 1; i < length; i++) {
            int val = list.get(i);
            if (dp[i - 1][1] % 2 == val % 2) {//前后奇偶性不变
                dp[i][0] = dp[i - 1][0] + val;
                dp[i][1] = val;
            } else {//前后奇偶性变化

                // dp[i] = Math.max(dp[i - 1] - x + n, Math.max(dp[i - 1] - x + list.get(i), dp[i - 2] + list.get(i)));
                if (dp[i - 1][0] < x) {
                    dp[i][0] = val;
                    dp[i][1] = val;
                } else {
                    dp[i][0] = dp[i - 1][0] - x + val;
                    dp[i][1] = val;
                }
            }
        }
        return dp[length - 1][0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 1, 9, 2};
        int x = 5;
        long rs = maxScore(nums, x);
        System.out.printf("" + rs);
    }
}
