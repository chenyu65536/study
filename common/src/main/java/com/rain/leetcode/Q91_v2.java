package com.rain.leetcode;

//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//
//
// "AAJF" ，将消息分组为 (1 1 10 6)
// "KJF" ，将消息分组为 (11 10 6)
//
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
//
// 题目数据保证答案肯定是一个 32 位 的整数。
//
//
//
// 示例 1：
//
//
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2：
//
//
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//
// 示例 3：
//
//
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
//
//
// 示例 4：
//
//
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含数字，并且可能包含前导零。
//
// Related Topics 字符串 动态规划
public class Q91_v2 {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 0; i < chars.length; i++) {
            int currentNum = count(chars[i], chars[i + 1]);
            if (currentNum == -10) {
                return 0;
            }
            int currentCount = count(chars[i], chars[i + 1]);
            dp[i] = currentCount;
        }
        return dp[dp.length - 1];
    }

    private int count(char c1, char c2) {
        if (c1 == '0' && c2 == '0') {
            return -10;
        }
        int numb1 = c1 - '0';
        int numb2 = c2 - '0';

        int numb = numb1 * 10 + numb2;

        if (numb > 26) {
            //只能看第一位
            if (numb2 == 0) {//0不能做首位且首位要小于3
                return -10;
            }
            return 1;
        } else {//<=26
            //只能看第一位
            if (numb2 == 0) {//0不能做首位且首位要小于3
                return 1;
            }
            return 2;
        }
    }


    public static void main(String[] args) {
        Q91_v2 q91 = new Q91_v2();
        System.out.println("" + q91.numDecodings("11106"));
        System.out.println("" + q91.numDecodings("12"));
        System.out.println("" + q91.numDecodings("226"));
        System.out.println("" + q91.numDecodings("0"));
        System.out.println("" + q91.numDecodings("06"));
    }
}
