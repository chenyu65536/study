package com.rain.leetcode.medium;

import java.util.*;

public class Q187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                res.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<String> rs = Q187.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.printf("11");
    }
}
