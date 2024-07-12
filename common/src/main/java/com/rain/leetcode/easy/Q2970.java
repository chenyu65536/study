package com.rain.leetcode.easy;

public class Q2970 {

    public static int incremovableSubarrayCount(int[] nums) {
        int length = nums.length;
        int i = 1;
        int rs = 3;//保留头、保留尾、全干掉

        //保头
        for (; i < length && nums[i] > nums[i - 1]; i++) {
            rs++;
        }
        //单调递增
        if (i == length) {
            return (1 + length) * length / 2;
        }
        //保尾
        int j = length - 2;
        for (; j >= 0 && nums[j] < nums[j + 1]; j--) {
            rs++;
        }

        //去除中间数，保证单调性
        int n = j + 1;
        for (int m = 0; m < i; m++) {
            while (n < length && nums[n] <= nums[m]) {
                n++;
            }
            rs += length - n;
        }
        return rs;
    }

    public static void main(String[] args) {
        incremovableSubarrayCount(new int[]{6,5,7,8});
    }
}
