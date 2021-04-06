package com.rain.leetcode.easy.e1;
//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学
// 👍 312 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q168 {

    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            sb.append(((char) Character.toUpperCase(65 + ((n - 1) % 26))));
            n = (n - 1) / 26;
            if (n == 0) {
                break;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.printf(convertToTitle(1));
    }
}
