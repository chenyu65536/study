package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] rs = new int[length];
        Arrays.fill(rs, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * length; i++) {
            int idx = i % length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                rs[stack.pop()] = nums[idx];
            }
            if (rs[idx] == -1) {
                stack.push(idx);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q503.nextGreaterElements(new int[]{5,4,3,2,1});
    }
}
