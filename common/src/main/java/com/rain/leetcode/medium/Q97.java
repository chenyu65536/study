package com.rain.leetcode.medium;

public class Q97 {

    char[] chars1;
    char[] chars2;
    char[] chars3;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        chars1 = s1.toCharArray();
        chars2 = s2.toCharArray();
        chars3 = s3.toCharArray();
        return dfs(s1.length() - 1, s2.length() - 1, s3.length() - 1);
    }

    public boolean dfs(int i, int j, int m) {
        if (m == -1) {
            return true;
        }
        if (i >= 0 && j >= 0 && chars1[i] == chars3[m] && chars2[j] == chars3[m]) {
            return dfs(i - 1, j, m - 1) || dfs(i, j - 1, m - 1);
        }
        if (i >= 0 && chars1[i] == chars3[m]) {
            return dfs(i - 1, j, m - 1);
        }
        if (j >= 0 && chars2[j] == chars3[m]) {
            return dfs(i, j - 1, m - 1);
        }
        return false;
    }
}
