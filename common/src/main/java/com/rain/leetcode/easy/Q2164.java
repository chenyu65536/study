package com.rain.leetcode.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2164 {
    public int[] sortEvenOdd(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return nums;
        }
        //奇数递减   按 非递增 顺序排列 nums 奇数下标 上的所有值。
        PriorityQueue<Integer> oddQ = new PriorityQueue<>((a, b) -> (b - a));
        //偶数递增  按 非递减 顺序排列 nums 偶数下标 上的所有值。
        PriorityQueue<Integer> evenQ = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 1; i < len; ) {
            oddQ.add(nums[i]);
            evenQ.add(nums[i - 1]);
            i += 2;
        }
        if (len % 2 == 1) {
            evenQ.add(nums[nums.length - 1]);
        }
        int i = 1;
        while (!oddQ.isEmpty()) {
            nums[i] = oddQ.poll();
            nums[i - 1] = evenQ.poll();
            i += 2;
        }

        if (!evenQ.isEmpty()) {
            nums[len - 1] = evenQ.poll();
        }
        return nums;
    }


    public int[] sortEvenOdd2(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return nums;
        }
        //奇数递减   按 非递增 顺序排列 nums 奇数下标 上的所有值。
        Integer[] oddQ = new Integer[len / 2];
        Integer[] evenQ = new Integer[len / 2 + len % 2];

        for (int i = 1; i < len; ) {
            oddQ[i / 2] = nums[i];
            evenQ[i / 2] = nums[i - 1];
            i += 2;
        }
        if (len % 2 == 1) {
            evenQ[evenQ.length - 1] = nums[nums.length - 1];
        }
        Arrays.sort(oddQ, (a, b) -> (b - a));
        Arrays.sort(evenQ);
        for (int i = 1; i < len; ) {
            nums[i] = oddQ[i / 2];
            nums[i - 1] = evenQ[i / 2];
            i += 2;
        }

        if (len % 2 == 1) {
            nums[len - 1] = evenQ[evenQ.length - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21};
        Q2164 q2164 = new Q2164();
        int[] rs = q2164.sortEvenOdd(nums);
        System.out.printf("_" + nums);
    }
}
