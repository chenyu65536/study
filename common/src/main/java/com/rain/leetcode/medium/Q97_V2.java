package com.rain.leetcode.medium;

public class Q97_V2 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length() + 1, n = s2.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        String s1 = "aabc", s2 = "abad", s3 = "aabadabc";
        //s1 = "aa",s2 = "abad",s3 = "aabada";
        Q97_V2 q97 = new Q97_V2();
        boolean rs = q97.isInterleave(s1, s2, s3);
        System.out.printf("11");
    }
}
