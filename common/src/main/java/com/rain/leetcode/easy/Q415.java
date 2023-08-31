package com.rain.leetcode.easy;
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//
//
// 示例 1：
//
//
//输入：num1 = "11", num2 = "123"
//输出："134"
//
//
// 示例 2：
//
//
//输入：num1 = "456", num2 = "77"
//输出："533"
//
//
// 示例 3：
//
//
//输入：num1 = "0", num2 = "0"
//输出："0"
//
//
//
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
//
//
// Related Topics 数学 字符串 模拟 👍 788 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q415 {

    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        char[] rs = new char[length + 1];
        for (int i = 0; i < length; i++) {
            int num1Val = 0;
            if (num1.length() - 1 - i >= 0) {
                num1Val = (num1.charAt(num1.length() - 1 - i) - '0');
            }

            int num2Val = 0;
            if (num2.length() - 1 - i >= 0) {
                num2Val = (num2.charAt(num2.length() - 1 - i) - '0');
            }
            int sum = num2Val + num1Val;
            if (rs[rs.length - 1 - i] != '\0') {
                sum += rs[rs.length - 1 - i] - '0';
            }
            if (sum > 9) {
                rs[rs.length - 1 - i - 1] = (char)(sum / 10 +'0');
                rs[rs.length - 1 - i] = (char)(sum % 10 +'0');
            } else {
                rs[rs.length - 1 - i] =  (char)(sum % 10 +'0');
            }
        }
        return String.valueOf(rs).replace("\u0000", "");
    }

    public static void main(String[] args) {
        //输入：num1 = "11", num2 = "123"
//输出："134"
        Q415 q415 = new Q415();
        String rs = q415.addStrings("6913259244", "71103343");
        System.out.printf("_" + rs);
    }
}
