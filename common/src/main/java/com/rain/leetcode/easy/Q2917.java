package com.rain.leetcode.easy;

public class Q2917 {

    public int findKOr(int[] nums, int k) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isMatch = true;
            for (int j = 0; j < k; j++) {
                int temp = (int) Math.pow(2, j);
                if ((temp & nums[i]) != temp) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rs += (int) Math.pow(2, i);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 12, 9, 8, 9, 15};
        int k = 4;
        Q2917 q2917 = new Q2917();
        int rs = q2917.findKOr(nums, k);
        System.out.printf("" + rs);
    }
}
