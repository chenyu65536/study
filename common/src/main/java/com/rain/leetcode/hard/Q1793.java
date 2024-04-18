package com.rain.leetcode.hard;

public class Q1793 {
    public static int maximumScore(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            for (int j = k; k < nums.length; k++) {
                int leftSum = sum[k] - sum[i];
                int rightSum = sum[j + 1] - sum[k] - nums[k];
                max = Math.max(max, (leftSum + rightSum) * (j - i + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
       /* 测试用例:[1,4,3,7,4,5]
        3*/
        int[] nums = new int[]{1,4,3,7,4,5};
        int k = 3;
        int rs  = Q1793.maximumScore(nums,k);
        System.out.printf("1");

    }
}
