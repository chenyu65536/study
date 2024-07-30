package com.rain.leetcode.medium;

import java.util.Stack;

public class Q2101 {
    public int maximumDetonation(int[][] bombs) {
        int length = bombs.length;

        int rs = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            //   if (vis[i]) continue;
            int cnt = 0;
            stack.add(bombs[i]);
            boolean[] vis = new boolean[length];
            vis[i] = true;
            while (!stack.isEmpty()) {
                cnt++;
                int[] bomb = stack.pop();
                int x = bomb[0], y = bomb[1], r = bomb[2];

                for (int j = 0; j < length; j++) {
                    if (vis[j]) continue;

                    int x1 = bombs[j][0], y1 = bombs[j][1];

                    if (Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2) <= Math.pow(r, 2)) {
                        stack.add(bombs[j]);
                        vis[j] = true;
                    }
                }
            }
            rs = Math.max(rs, cnt);
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2101 q2101 = new Q2101();
        q2101.maximumDetonation(new int[][]{
                {2,1,3},
                {6,1,4}
        });
        Stack<int[]> stack = new Stack<>();
    }
}
