package com.rain.leetcode.medium;

import java.util.Arrays;

public class Q2171 {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] preSum = new long[beans.length + 1];
        preSum[0] = 0;

        for (int i = 0; i < beans.length; i++) {
            preSum[i + 1] = preSum[i] + beans[i];
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            //long removeCount = preSum[preSum.length - 1] - beans[i] - (beans.length - i-1) * beans[i];
            long removeCount = preSum[preSum.length - 1]  - (long) (beans.length - i) * beans[i];
            min = Math.min(removeCount, min);
        }
        return min;
    }

    public static void main(String[] args) {
        Q2171 q2171 = new Q2171();
        int[] beans = new int[]{4, 1, 6, 5};
        long rs = q2171.minimumRemoval(beans);
        System.out.printf("__" + rs);
    }
}
