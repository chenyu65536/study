package com.rain.leetcode.easy.e1;

//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// 示例 1:
//
// 输入: "A"
//输出: 1
//
//
// 示例 2:
//
// 输入: "AB"
//输出: 28
//
//
// 示例 3:
//
// 输入: "ZY"
//输出: 701
//
// 致谢：
//特别感谢 @ts 添加此问题并创建所有测试用例。
// Related Topics 数学
// 👍 199 👎 0

public class Q171 {

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int columnNo = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int part = chars[i] - 64;
            for (int j = 0; j < chars.length - i-1; j++) {
                part = part * 26;
            }
            columnNo += part;
        }
        return columnNo;
    }

    public static void main(String[] args) {
        int va = titleToNumber("AB");
        System.out.printf("11");
    }
}
