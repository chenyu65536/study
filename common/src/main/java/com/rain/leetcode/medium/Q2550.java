package com.rain.leetcode.medium;

public class Q2550 {

    public static int monkeyMove(int n) {
        long total = (long) Math.pow(2,n);
        long mod= (int)(1e9+7);
        return  (int)((total-2)%mod);
    }

    public static void main(String[] args) {
        monkeyMove(3);
    }
}
