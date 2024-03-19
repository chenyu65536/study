package com.rain.leetcode.easy;

public class Q2652 {

    public int sumOfMultiples(int n) {
        int rs = 0;
        for (int i = 0; i <= n;) {
            rs += i;
            i += 3;
        }
        for (int i = 0; i <= n;) {
            if (i % 3 == 0) {
                i += 5;
                continue;
            }
            rs += i;
            i += 5;
        }
        for (int i = 0; i <= n;) {
            if (i % 3 == 0 || i % 5 == 0) {
                i += 7;
                continue;
            }
            rs += i;
            i += 7;
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2652 q2652 = new Q2652();
        int rs = q2652.sumOfMultiples(7);
        System.out.printf("" + rs);
    }
}
