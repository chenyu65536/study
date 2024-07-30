package com.rain.leetcode.medium;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        //"10","6","9","3","+","-11","*","/","*","17","+","5","+"
        //22,"+"
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //"+"、"-"、"*" 或 "/"

            if (token.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 + val2);

            } else if (token.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (token.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 * val2);
            } else if (token.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Q150 q150 = new Q150();
        int res = q150.evalRPN(strs);
        System.out.printf("" + res);
    }
}
