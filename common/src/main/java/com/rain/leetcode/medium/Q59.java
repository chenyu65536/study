package com.rain.leetcode.medium;

public class Q59 {


    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int val = 1;
        int times = 0;
        while (times < Math.ceil(n/2f)) {
            int i = times;
            int j = times;
            for (; i < n - times; ) {
                rs[j][i] = val;
                val++;
            }
            i--;
            j++;
            for (; j < n - times; j++) {
                rs[j][i] = val;
                val++;
            }
            i--;
            j--;
            for (; i >= times; i--) {
                rs[j][i] = val;
                val++;
            }
            i++;
            j--;
            for (; j > times; j--) {
                rs[j][i] = val;
                val++;
            }
            times++;
        }
        return rs;
    }
    public static void main(String[] args) {
        Q59 q59 = new Q59();
        q59.generateMatrix(1);
    }


}
