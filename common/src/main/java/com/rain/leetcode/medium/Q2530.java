package com.rain.leetcode.medium;

import java.util.PriorityQueue;

public class Q2530 {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            queue.offer(num);
        }
        long rs = 0;
        while (k > 0) {
            int val = queue.poll();
            queue.offer((int) Math.ceil(val/3D));
            rs += val;
            k--;
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2530 q2530 = new Q2530();
        int[] nums = new int[]{1, 10, 3, 3, 3};
        int k = 3;
        long rs = q2530.maxKelements(nums, k);
        System.out.printf("" + rs);
    }
}
