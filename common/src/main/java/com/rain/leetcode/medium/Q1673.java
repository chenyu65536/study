package com.rain.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class Q1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        //往前找最小的

        int[] rs = new int[k];
        int currentPos = 0;
        PriorityQueue<Integer> stack = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        int i = 0;
        while (currentPos < k) {
            //找到最小的之后接着往后找最小的
            for (; i <= len - k + currentPos; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    stack.poll();
                }
                stack.add(i);
            }

            rs[currentPos] = stack.poll();
            currentPos++;
        }

        for (int j = 0; j < rs.length; j++) {
            rs[j] = nums[rs[j]];
        }
        return rs;
    }


    public int[] mostCompetitive2(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && n - i + stack.size() > k && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] res = new int[k];
        while (stack.size() > k) {
            stack.pop();
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;

}

    public static void main(String[] args) {
        Q1673 q1673 = new Q1673();
        int[] nums = new int[]{2,4,3,3,5,4,9,6};
        //q1673.mostCompetitive(nums,4);


        nums = new int[]{
                2,10,6,10,8,2,7,10,0,5,1,3,3,2,8,6,10,1,2,7,7,2,8,2
                ,0,10,5,8,1,2,4,4,3,9,6,0,0,0,10,4,7,1,2,0,6,6,0,8,5
                ,4,4,6,8,4,10,4,4,1,5,5,6,8,3,6,3,4,6,0,7,5,5,3,7,1,4
                ,0,8,9,4,10,5,3,3,0,9,4,10,6,10,5,5,0,0,6,1,9,1,8,10,5
                ,2,0,9,1,3,10,5,9,6,7,6,1,10,2,3,7,3,1,4,5,6,6,5,10,1,4
                ,6,8,10,8,3,0,7,2,10,7,8,2,1,3,7,2,4,4,7,4,7,9,10,3,7,9,6
                ,0,9,0,6,8,0,4,3,5,5,6,2,5,4,4,3,2,8,0,6,4,9,7,7,4,10,1,2,1
                ,10,1,10,7,10,8,6,9,1,3,10,1,6,6,6,2,6,1,8,2,1,2,10,2,5,3,5,8
                ,6,5,9,7,10,5,1,8,0,1,2,5,8,5,8,7,2,2,8,0,4,6,7,9,3,8,0,5,6,8,0
                ,0,10,3,9,10,10,8,0,1,3,10,0,0,7,7,5,4,2,1,4,8,4,3,2,10,0,7,8,4,3
                ,10,8,10,2,8,7,5,10,3,2,10,5,4,1,6,2,1,4,4,7,8,5,7,10,2,3,1,7,3,2
                ,5,5,2,2,1,10,9,3,3,4,6,3,10,6,7,5,8,0,0,2,7,6,4,8,4,0,1,9,2,6,1,8,2,7,0,7,2,7,3,8,5,2,9,7,1,3,7,3,2,8,4,1,4,3,3,6,3,8,0,5,7,8,6,1,9,7,2,9,7,4,2,0,8,4,0,4,10,9,0,6,6,9,5,9,1,2,9,7,4,5,9,9,6,4,0,0,3,5,6,2,2,8,8,1,2,10,7,6,5,8,9,9,5,0,10,10
        };
        q1673.mostCompetitive(nums,193);
        System.out.printf("");
    }

}
