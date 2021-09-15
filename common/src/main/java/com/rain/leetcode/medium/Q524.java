package com.rain.leetcode.medium;


import java.util.Arrays;
import java.util.List;


//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
//
//
// 示例 2：
//
//
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 1000
// s 和 dictionary[i] 仅由小写英文字母组成
//
// Related Topics 数组 双指针 字符串 排序
// 👍 221 👎 0
public class Q524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String matchStr = "";
        for (String word : dictionary) {
            int i = 0, j = 0;
            for (; i < word.length(); i++) {
                while (j < s.length()) {
                    if (s.charAt(j) == word.charAt(i)) {
                        if (i == word.length() - 1) {
                            if (word.length() > matchStr.length() || (word.length() == matchStr.length() && word.compareTo(matchStr) < 0)) {
                                matchStr = word;
                            }
                        }
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }
        return matchStr;
    }

    public static void main(String[] args) {
        //"abpcplea", dictionary = ["a","b","c"]
        String s = "abpcplea";
        //"abpcplea" ["ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa"] 测试结果:"abccclllpppeeaaaa" 期望结果:"apple" stdout:
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa");

        Q524 q524 = new Q524();
        String rs = q524.findLongestWord(s, dictionary);

        System.out.printf("" + rs);
    }
}
