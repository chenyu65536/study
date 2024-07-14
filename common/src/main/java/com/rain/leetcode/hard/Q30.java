package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        int k = words[0].length();
        Set<String> dicts = new HashSet<>();
        for (String word : words) dicts.add(word);

        List<Integer> rs = new ArrayList<>();

        char[] chars = new char[k];
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            chars[i % k] = s.charAt(i);
            if ((i + 1)% k == 0) {
                if ((!dicts.contains(new String(chars)) || i == s.length() - 1) && idx != -1) {
                    //找到了，添加结果
                    rs.add(idx);
                    idx = -1;
                    continue;
                }
                if (dicts.contains(new String(chars)) && idx == -1) {//找到了，设置开头索引
                    idx = i - k + 1;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        findSubstring(s, words);
    }
}
