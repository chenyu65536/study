package com.rain.leetcode.medium;
//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//
//
// 任何左括号 ( 必须有相应的右括号 )。
// 任何右括号 ) 必须有相应的左括号 ( 。
// 左括号 ( 必须在对应的右括号之前 )。
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
// 一个空字符串也被视为有效字符串。
//
//
// 示例 1:
//
//
//输入: "()"
//输出: True
//
//
// 示例 2:
//
//
//输入: "(*)"
//输出: True
//
//
// 示例 3:
//
//
//输入: "(*))"
//输出: True
//
//
// 注意:
//
//
// 字符串大小将在 [1，100] 范围内。
//
// Related Topics 栈 贪心 字符串 动态规划
// 👍 362 👎 0

import java.util.Stack;

public class Q678 {

    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') {
                star.push(i);
            }

            if (ch == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!star.isEmpty() && !left.isEmpty() && star.size() >= left.size()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }
        return left.size() == 0;
    }

    public static void main(String[] args) {
        Q678 q678 = new Q678();
        String str = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        str=         "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        boolean rs = q678.checkValidString(str);
        System.out.printf("" + rs);
    }
}
