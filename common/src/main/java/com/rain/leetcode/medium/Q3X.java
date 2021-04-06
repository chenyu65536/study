package com.rain.leetcode.medium;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4970 👎 0

import java.util.HashSet;

public class Q3X {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLength = Math.max(maxLength, lengthOfLongestStart(s,i));
        }
        return maxLength;
    }

    public static int lengthOfLongestStart(String s, int i) {
        HashSet set = new HashSet();
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return set.size();
            }
            set.add(ch);
        }
        return set.size();
    }
    //dvdf

    public static void main(String[] args) {
        System.out.printf(lengthOfLongestSubstring("dvdf") + "");
    }
}
