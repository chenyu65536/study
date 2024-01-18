package com.rain.leetcode.medium;

import java.util.LinkedList;
import java.util.Objects;

public class Q2645 {

    public int addMinimum(String word) {
        LinkedList<Character> stack = new LinkedList<>();
        int rs = 0;
        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            Character cChar = stack.pop();
            Character bChar = ' ';
            if (!stack.isEmpty()) {
                bChar = stack.pop();
            }
            Character aChar = null;
            if (!stack.isEmpty()) {
                aChar = stack.pop();
            }
            if (cChar == 'c' && Objects.equals(bChar, 'b') && Objects.equals(aChar, 'a')) {
                continue;
            }
            if (bChar != null && cChar > bChar) {
                if (aChar != null) {
                    stack.push(aChar);
                }
                rs = rs + 1;
                continue;
            }

            rs = rs + 2;
            if (aChar != null) {
                stack.push(aChar);
            }
            if (bChar != null) {
                stack.push(bChar);
            }
        }
        return rs;
    }


    public int addMinimum2(String word) {
        int rs = 0;
        int i = word.length() - 1;
        while (i > 1) {
            char cChar = word.charAt(i);
            char bChar = word.charAt(i - 1);
            char aChar = word.charAt(i - 2);
            if (cChar == 'c' && bChar == 'b' && aChar == 'a') {
                i = i - 3;
                continue;
            }
            if (cChar > bChar) {
                i = i - 2;
                rs = rs + 1;
                continue;
            }
            i = i - 1;
            rs = rs + 2;
        }
        if (i >= 0) {
            if (i == 0) {
                rs = rs + 2;
            } else if (word.charAt(1) > word.charAt(0)) {
                rs = rs + 1;
            } else {
                rs = rs + 4;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2645 q2645 = new Q2645();
        int rs = q2645.addMinimum2("abc");
        System.out.printf("" + rs);
    }
}
