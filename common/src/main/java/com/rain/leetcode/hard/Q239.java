package com.rain.leetcode.hard;

import java.util.LinkedList;

public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] res = new int[len];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!list.isEmpty() && nums[i]>=nums[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
            if(i-list.getFirst()==k){
                list.removeFirst();
            }
            if(i>=k-1){
                res[i-k+1] = nums[list.getFirst()];
            }
        }
        return res;
    }
}