package com.rain.leetcode.hard;


public class Q41 {

    public static int firstMissingPositive(int[] nums) {

        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            // 当前槽位与数值相同
            max = Math.max(max, nums[i]);
            if (nums[i] == i)
                continue;
            // 当前槽位与数值不同
            int idx = i;
            int val = nums[i]-1;
            while (val < length && val >= 0 && val != idx) {
                int temp =  nums[val];//下一个需要查找的位置
                nums[val] = val;
                idx = val;
                val = temp-1;
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i) {
                return i+1;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
       // firstMissingPositive(new int[]{1, 2, 0});
        firstMissingPositive(new int[]{1,2,0});

    }
}
