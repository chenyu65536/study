package com.rain.leetcode.easy.e1;



import java.util.regex.Pattern;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 308 👎 0
public class Q125 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        // s = s.replaceAll("[^a-zA-Z0-9]", "");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static void main(String[] args) {
        isPalindrome("0P");
        isPalindrome("A man, a plan, a canal: Panama");

    }


}
