package com.rain.leetcode.medium;

import java.util.Arrays;

public class Q473 {
    boolean[] used;
    int[] matchsticks;
    int rs = 0;

    public boolean makesquare(int[] matchsticks) {
        int totalLength = 0;
        for (int matchstick : matchsticks) {
            totalLength += matchstick;
        }
        if (totalLength % 4 != 0) {
            return false;
        }
        int borderLength = totalLength / 4;
        Arrays.sort(matchsticks);
        used = new boolean[matchsticks.length];
        this.matchsticks = matchsticks;

        return rs == 4;
    }


    public void backTrack(int borderLength, int sum) {
    }

    public static void main(String[] args) {
        int[] matchsticks = new int[]{
                1, 1, 2, 2, 2
        };
        Q473 q473 = new Q473();
        boolean rs = q473.makesquare(matchsticks);
        System.out.println("" + rs);
    }
}
