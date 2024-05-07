package com.rain.leetcode.medium;

public class Q1017 {

    public static String baseNeg2(int n) {
        int length = Integer.toBinaryString(1000000000).length();

        boolean neg = n > 0;
        n = Math.abs(n);
        StringBuilder sb = new StringBuilder();
        while (length > 0) {
            int val = (int) Math.pow(-2, length);
            if (val > 0) {
                if (n >= val) {
                    sb.append('1');
                    n -= val;
                } else {
                    sb.append('0');
                }
            } else {
                if (n < val) {
                    sb.append('0');
                    n -= val;
                } else {
                    sb.append('1');
                }
            }
            length--;
        }
        sb.reverse();
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String rs = baseNeg2(2);
        System.out.printf("" + rs);
    }
}
