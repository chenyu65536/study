package com.rain.leetcode.medium;

public class Q2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int rs = garbage[0].length();
        int[] preSum = new int[travel.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1] + travel[i - 1];
        }
        int[] prePosition = new int[3];
        for (int i = 1; i < garbage.length; i++) {
            //处理垃圾的时间
            rs += garbage[i].length();
            //路程所花时间
            if (garbage[i].contains("M")) {
                rs += preSum[i] - preSum[prePosition[0]];
                prePosition[0] = i;
            }
            if (garbage[i].contains("P")) {
                rs += preSum[i] - preSum[prePosition[1]];
                prePosition[1] = i;
            }
            if (garbage[i].contains("G")) {
                rs += preSum[i] - preSum[prePosition[2]];
                prePosition[2] = i;
            }
        }
        return rs;
    }
}
