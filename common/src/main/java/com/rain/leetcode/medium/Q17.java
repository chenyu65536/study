package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯 👍 1523 👎 0
public class Q17 {


    List<String> rs = new ArrayList<>();
    String[] letterNums = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return rs;
        }
        backTracking(digits, 0);
        return rs;
    }

    StringBuilder prefix = new StringBuilder();

    private void backTracking(String digits, int index) {
        if (digits.length() == index) {
            rs.add(prefix.toString());
            return;
        }

        String str = letterNums[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            prefix.append(str.charAt(i));
            backTracking(digits, index+1);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q17 q17 = new Q17();
        String digits = "23";
        List<String> rs = q17.letterCombinations(digits);
        System.out.printf(rs.toString());
    }
}
