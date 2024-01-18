package com.rain.leetcode.easy;

import java.util.LinkedList;
import java.util.Stack;

public class Q2696 {

    public int minLength(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            //remove 'AB' Or 'CD'
            if (!stack.isEmpty() && ((ch == 'B' && stack.peek() == 'A') || (ch == 'D' && stack.peek() == 'C'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

}
