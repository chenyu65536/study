package com.rain.leetcode.easy;
//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
//
//
//
// 示例1:
//
//
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
//
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
//
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false
//
//
//
// 提示:
//
//
// 1 <= pattern.length <= 300
// pattern 只包含小写英文字母
// 1 <= s.length <= 3000
// s 只包含小写英文字母和 ' '
// s 不包含 任何前导或尾随对空格
// s 中每个单词都被 单个空格 分隔
//
//
// Related Topics 哈希表 字符串 👍 593 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if(p2s.containsKey(pattern.charAt(i)) && !p2s.get(pattern.charAt(i)).equals(strings[i])){
                return false;
            }
            if(s2p.containsKey(strings[i]) && s2p.get(strings[i])!= pattern.charAt(i)){
                return false;
            }
            p2s.put(pattern.charAt(i), strings[i]);
            s2p.put(strings[i], pattern.charAt(i));
        }
        return true;
    }
}
