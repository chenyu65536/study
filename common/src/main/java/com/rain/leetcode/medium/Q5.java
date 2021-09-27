package com.rain.leetcode.medium;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划 👍 4147 👎 0
public class Q5 {

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int[] max = new int[2];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j || j - i == 1) {
                        dp[i][j] = true;

                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }

                    if (dp[i][j] && j - i > max[1] - max[0]) {
                        max[1] = j;
                        max[0] = i;
                    }
                }
            }
        }
        return s.substring(max[0], max[1] + 1);
    }


    public static String longestPalindromeV2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int[] max = new int[2];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if ( j - i > max[1] - max[0]) {
                            max[1] = j;
                            max[0] = i;
                        }
                    }
                }
            }
        }
        return s.substring(max[0], max[1] + 1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        String rs = longestPalindrome(s);
        System.out.printf("" + rs);
    }
}
