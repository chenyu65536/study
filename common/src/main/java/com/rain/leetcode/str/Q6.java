package com.rain.leetcode.str;
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
//
//string convert(string s, int numRows);
//
//
//
// 示例 1：
//
//
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//
//
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// 示例 3：
//
//
//输入：s = "A", numRows = 1
//输出："A"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由英文字母（小写和大写）、',' 和 '.' 组成
// 1 <= numRows <= 1000
//
// Related Topics 字符串 👍 1598 👎 0


public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < numRows; i++) {
            //0 numRows+numRows-2
            int base = 0;
            int step = 0;
            while (base < length) {
                base = step * (numRows + numRows - 2);

                if (base + i < s.length()) {
                    sb.append(s.charAt(base + i));
                }
                int next = base + i + (numRows - i - 1) * 2;
                if (i > 0 && i < numRows - 1 && next < s.length()) {
                    sb.append(s.charAt(next));
                }
                step++;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Q6 q6 = new Q6();
        String rs = q6.convert(s, numRows);
        System.out.printf("" + rs);

       /* int row = q6.getRow(4, 3);
        System.out.printf("" + row);*/


        //  int row = q6.getCol(5, 3);
    }
}
