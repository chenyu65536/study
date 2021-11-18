package com.rain.leetcode.dp;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯 👍 2153 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q22 {

    List<String> rs = new ArrayList<>();
    char[] keys = new char[]{'(', ')'};
    StringBuilder sb = new StringBuilder();


    public List<String> generateParenthesis(int n) {
        backTrack(0, n, 0);
        return rs;
    }

    private void backTrack(int times, int n, int count) {
        if (times == n * 2) {
            if (count == 0) {
                rs.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < keys.length; i++) {
            char appendChar = keys[i];
            int leftCount = isValid(appendChar, count);
            if (leftCount >= 0) {
                sb.append(appendChar);
                backTrack(times + 1, n, leftCount);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }

    private int isValid(char appendChar, int count) {
        if (appendChar == '(') {
            count++;
        } else {
            count--;
        }
        return count;
    }

    public static void main(String[] args) {
        Q22 q22 = new Q22();
        List<String> rs = q22.generateParenthesis(3);
        System.out.printf("" + rs);
    }
}
