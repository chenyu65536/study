package com.rain.leetcode.easy;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Q2908 {

    public static int minimumSum(int[] nums) {
        int length = nums.length;
        int[][] minNums = new int[length][2];
        minNums[0][0] = nums[0];
        minNums[length-1][1] = nums[length-1];
        for (int i = 1; i < length; i++) {
            minNums[i][0] = Math.min(minNums[i - 1][0], nums[i]);
        }

        for (int i = length-2; i >=0; i--) {
            minNums[i][1] = Math.min(minNums[i + 1][1], nums[i]);
        }

        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > minNums[i - 1][0] && nums[i] > minNums[i +1][1]) {
                sum = Math.min(sum, nums[i]+minNums[i - 1][0] + minNums[i +1][1]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        minimumSum(new int[]{8,6,1,5,3});
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(a-b));
    }
}
