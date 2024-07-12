package com.rain.leetcode.hard;

import java.util.Arrays;

public class Q2742 {

    public int paintWalls(int[] cost, int[] time) {
        int length = cost.length;
        Integer[] avgCost = new Integer[length];
        for (int i = 0; i < length; i++) avgCost[i] = i;
        Arrays.sort(avgCost, (a, b) -> cost[b] * time[a] - cost[a] * time[b]);//按照平均成本 升序排,优先安排给免费的

        int[][][] dp = new int[length][2][2];
        dp[0][0][0] = 0;//free
        dp[0][0][1] = 0;
        dp[0][1][0] = cost[avgCost[0]];
        dp[0][1][1] = time[avgCost[0]];

        for (int i = 1; i < length; i++) {
            int idx = avgCost[i];

            //黑奴耗时低于员工,将这面墙给黑奴
            if (time[idx] + dp[i][0][1] <= dp[i][1][1]) {
                dp[i][0][0] = dp[i][0][0] + cost[idx];
                dp[i][0][1] = dp[i][0][1] + time[idx];
            } else {
                dp[i][1][0] = dp[i][1][0] + cost[idx];
                dp[i][1][1] = dp[i][1][1] + time[idx];
            }
        }
        return dp[length - 1][1][0];
    }

}
