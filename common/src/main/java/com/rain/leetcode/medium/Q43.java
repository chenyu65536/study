package com.rain.leetcode.medium;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
//
//
//
// 示例 1:
//
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 200
// num1 和 num2 只能由数字组成。
// num1 和 num2 都不包含任何前导零，除了数字0本身。
//
//
// Related Topics 数学 字符串 模拟 👍 1274 👎 0

import java.util.Map;

public class Q43 {

    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length()];
        for (int i = num1.toCharArray().length - 1; i > -1; i--) {
            int num1Int = (num1.charAt(i) - '0');
            for (int j = num2.toCharArray().length - 1; j > -1; j--) {
                int rs = num1Int * (num2.charAt(j) - '0');
                int tempIndex = i + j + 1;

                nums[tempIndex] += rs;
                while (nums[tempIndex] > 9) {
                    int temp = nums[tempIndex];
                    nums[tempIndex] = temp % 10;
                    nums[tempIndex - 1] += temp / 10;
                    tempIndex--;
                }
            }
        }
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (i < nums.length) {
            sb.append(nums[i]);
            i++;
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q43 q43 = new Q43();
        String num1 = "0", num2 = "0";
        String rs = q43.multiply(num1, num2);
        System.out.printf("" + rs);
    }
}
