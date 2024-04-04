package com.rain.leetcode;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * Related Topics
 * 数组
 * 哈希表
 * 字符串
 * 排序
 * <p>
 * 👍 1571
 */
public class Q49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> rs = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a'] = count[strs[i].charAt(j) - 'a'] + 1;
            }
            //拼接key
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (count[j] != 0) {
                    key.append('a' + j).append(count[j]);
                }
            }
            String keyStr = key.toString();
            List<String> values = map.containsKey(keyStr) ? map.get(keyStr) : new ArrayList<>();
            values.add(strs[i]);
            map.put(keyStr, values);
        }
        map.forEach((k,v)->rs.add(v));
        return rs;
    }
}
