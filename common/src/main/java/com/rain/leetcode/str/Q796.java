package com.rain.leetcode.str;
//给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
//
// s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
//
//
// 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
//
//
//
//
// 示例 1:
//
//
//输入: s = "abcde", goal = "cdeab"
//输出: true
//
//
// 示例 2:
//
//
//输入: s = "abcde", goal = "abced"
//输出: false
//
//
//
//
// 提示:
//
//
// 1 <= s.length, goal.length <= 100
// s 和 goal 由小写英文字母组成
//
// Related Topics 字符串 字符串匹配 👍 216 👎 0


public class Q796 {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (compare(s, goal, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(String s, String goal, int start) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt((start + left) % s.length()) != goal.charAt(left)) {
                return false;
            }
            left++;
        }
        return true;
    }



    public static void main(String[] args) {
        //输入: s = "abcde", goal = "cdeab"
//输出: true
//输入: s = "abcde", goal = "abced"

        String s = "abcde";
        String goal = "cdeab";
        Q796 q796 = new Q796();
        boolean rs = q796.rotateString(s, goal);

        System.out.printf("" + rs);
    }
}
