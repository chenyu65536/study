package com.rain.leetcode.easy.e1;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/11/23 7:14 下午
 */
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 521 👎 0

public class Q67 {


    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int length = Math.max(aLength, bLength);

        int carry = 0;
        for (int i = 0; i < length; i++) {

            int base = aLength - i-1>= 0 ? Integer.parseInt(a.substring(aLength - i-1, aLength - i)) : 0;
            int base2 = bLength - i -1>= 0 ? Integer.parseInt(b.substring(bLength - i-1, bLength - i)) : 0;

            result.append((base + base2 + carry) % 2);
            carry = (base + base2 + carry) / 2;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        if ("0".equals(a)) {
            return b;
        }
        if ("0".equals(b)) {
            return a;
        }
        StringBuilder result = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int length = Math.max(aLength, bLength);

        int carry = 0;
        int aStartIndex = aLength-1;
        int bStartIndex = bLength-1;
        for (int i = length - 1; i >= 0; i--) {

            int base = aStartIndex >= 0 ? Integer.parseInt(a.substring(aStartIndex, aStartIndex + 1)) : 0;
            int base2 = bStartIndex >= 0 ? Integer.parseInt(b.substring(bStartIndex, bStartIndex + 1)) : 0;

            result.append((base + base2 + carry) % 2);
            carry = (base + base2 + carry) / 2;
            aStartIndex--;
            bStartIndex--;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
      //  System.out.printf(addBinary("1", "01"));
    }

}
