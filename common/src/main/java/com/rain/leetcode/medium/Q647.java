package com.rain.leetcode.medium;
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。
//
// 子字符串 是字符串中的由连续字符组成的一个序列。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//
//
// 示例 1：
//
//
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//
//
// 示例 2：
//
//
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由小写英文字母组成
//
// Related Topics 字符串 动态规划 👍 682 👎 0

public class Q647 {

    public static int countSubstringsDpV2(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static int countSubstringsDp(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = i; j < s.length(); j++) {
                if (chars[i] == chars[j]) {
                    if (i == j) {
                        dp[i][j] = true;
                        count++;
                    } else if (j == i + 1) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = true;
                            count++;
                        }
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static int countSubstrings(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int length = 0;
                boolean match = true;
                while (i + length <= j - length) {
                    if (chars[i + length] != chars[j - length]) {
                        match = false;
                        break;
                    } else {
                        length++;
                    }
                }
                if (match & length > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aba";
        int rs = countSubstringsDpV2(s);
        System.out.printf("" + rs);
    }
}
