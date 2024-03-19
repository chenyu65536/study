package com.rain.leetcode.easy;

public class Q2609 {
    public static int findTheLongestBalancedSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                continue;
            }
            int zeroCount = 0;
            int oneCount = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                zeroCount++;
                i++;
            }

            while (i < s.length() && s.charAt(i) == '1') {
                oneCount++;
                i++;
            }
            i--;
            int length = Math.min(oneCount, zeroCount);
            maxLength = Math.max(maxLength, length * 2);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int rs = Q2609.findTheLongestBalancedSubstring("01000111");
        System.out.printf("" + rs);
    }
}
