package com.rain.leetcode.easy;

import java.util.Arrays;

public class Q2864 {
    public String maximumOddBinaryNumber2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int move = 0;
        if (chars[0] == '0' && chars[chars.length - 1] == '1') {
            move = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1 - move; i >= 0; i--) {
            sb.append(chars[i]);
        }
        if (move == 1) {
            sb.append('1');
        }
        return sb.toString();
    }
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length-1;
        while (i >= 0) {
            if (chars[i] == '1') {
                chars[i] = '0';
                chars[chars.length - 1] = '1';
                break;
            }
            i--;
        }

        i=0;
        int j=chars.length-2;
        while (j > i) {
            if (chars[i] == '1') {
                i++;
                continue;
            }
            if (chars[j] == '0') {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q2864 q2864 = new Q2864();
        System.out.println(q2864.maximumOddBinaryNumber("010"));
    }
}
