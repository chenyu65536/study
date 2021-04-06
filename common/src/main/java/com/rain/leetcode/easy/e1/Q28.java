package com.rain.leetcode.easy.e1;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/10/22 5:11 下午
 */
public class Q28 {

    //实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
// 👍 602 👎 0

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        int step = 0;
        String[] stacks = haystack.split("");
        String[] parts = needle.split("");
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].equals(parts[step])) {
                step++;
            } else {
                i = i - step;
                step = 0;
            }
            if (step == parts.length) {
                return i - step + 1;
            }
        }
        return -1;
    }


    public static int strStr2(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        int length = needle.length();
       // int maxIndex = haystack.length() - needle.length() + 1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.printf("" + strStr2("a", "a"));
    }

}
