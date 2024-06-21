package com.rain.leetcode.medium;

import java.util.Arrays;

public class Q522 {
    public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int length = strs.length;
        for (int i = 0; i < length; i++) {
        }
        return -1;
    }

    public static void main(String[] args) {
        //int rs = findLUSlength(new String[]{"aba", "cdc", "eae"});
        int rs = findLUSlength(new String[]{"aaa", "aaa", "aa"});
        System.out.printf("" + rs);
    }
}
