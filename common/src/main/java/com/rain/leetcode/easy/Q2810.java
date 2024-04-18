package com.rain.leetcode.easy;


public class Q2810 {
    public static String finalString(String s) {
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                rs.reverse();
            } else {
                rs.append(s.charAt(i));
            }
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        String rs = finalString("viwif");
        System.out.printf("" + rs);
    }

}
