package com.rain.leetcode.easy;

public class Q1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //8,1,2,2,3
        int[] count = new int[101];// 1->1 2->2 3->1
        for (int num : nums) {
            count[num]++;
        }

        int[] total = new int[101];
        for (int i = 1; i <= 100; i++) {
            total[i] = total[i - 1] + count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = total[nums[i]];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                8, 1, 2, 2, 3
        };
        Q1365 q1365 = new Q1365();
        q1365.smallerNumbersThanCurrent(nums);
    }
}
