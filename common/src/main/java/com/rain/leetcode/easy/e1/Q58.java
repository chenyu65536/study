package com.rain.leetcode.easy.e1;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/11/16 5:15 下午
 */
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串
// 👍 257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q58 {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String strTrim = s.trim();
        if ("".equals(strTrim)) {
            return 0;
        }

        for (int i = strTrim.length() - 1; i >= 0; i--) {
            if (' ' == strTrim.charAt(i)) {
                return strTrim.length() - i - 1;
            } else if (i == 0) {
                return strTrim.length();
            }
        }
        return 0;
    }

}
