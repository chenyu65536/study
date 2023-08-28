package com.rain.leetcode.easy;
//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
//输入：s = "egg", t = "add"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "foo", t = "bar"
//输出：false
//
// 示例 3：
//
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 5 * 10⁴
// t.length == s.length
// s 和 t 由任意有效的 ASCII 字符组成
//
//
// Related Topics 哈希表 字符串 👍 632 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!ts.containsKey(t.charAt(i))) {
                ts.put(t.charAt(i), s.charAt(i));
            } else if (ts.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            if (!st.containsKey(s.charAt(i))) {
                st.put(s.charAt(i), t.charAt(i));
            } else if (st.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        if (st.size() != ts.size()) {
            return false;
        }
        for (Character key : st.keySet()) {
            Character val = st.get(key);
            Character key2 = ts.get(val);
            if (key != key2) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //	测试用例:"egg"
        //			"add"
        Q205 q205 = new Q205();
        boolean rs = q205.isIsomorphic("egg", "add");
        System.out.printf("" + rs);
    }
}
