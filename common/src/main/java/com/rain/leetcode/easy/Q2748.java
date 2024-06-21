package com.rain.leetcode.easy;

public class Q2748 {


    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int rs = gcd(10, 3);
        System.out.printf("" + rs);
    }
}
