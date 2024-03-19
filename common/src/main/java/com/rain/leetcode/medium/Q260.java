package com.rain.leetcode.medium;

public class Q260 {

    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        //根据num1^num2的结果将nums拆分开
        int lsb = (xor == Integer.MIN_VALUE ? xor : xor & (-xor));
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lsb & nums[i]) == 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        System.out.println("" + (a & -a));
        System.out.println("" + Integer.toBinaryString(0^a));
        System.out.println("" + Integer.toBinaryString(1^a));

        //00000011
        //1xxxxx11
    }
}
