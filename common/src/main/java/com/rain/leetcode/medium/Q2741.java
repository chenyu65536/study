package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q2741 {
    List<Integer>[] maps;
    int rs = 0;
    boolean[] used;

    public int specialPerm(int[] nums) {
        //最小值为1，
        int length = nums.length;
        this.maps = new ArrayList[length];
        this.used = new boolean[length];
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    list.add(j);
                }
            }
            maps[i] = list;
        }


        for (int i = 0; i < length; i++) {
            used[i] = true;
            backTrace(maps[i], length - 1);
            used[i] = false;
        }
        return rs;
    }


    public void backTrace(List<Integer> list, int left) {
        if (left == 0) {
            rs++;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int idx = list.get(i);
            if (used[idx]) continue;
            used[idx] = true;

            backTrace(maps[idx], left - 1);

            used[idx] = false;
        }
    }

    public static void main(String[] args) {
        Q2741 q2741 = new Q2741();
        int rs = q2741.specialPerm(new int[]{2, 3, 6});//2
        System.out.printf("" + rs);
    }
}
