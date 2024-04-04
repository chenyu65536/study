package com.rain.leetcode.easy;
//给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
//
//
// num1 和 num2 直接连起来，得到 num 各数位的一个排列。
//
//
//
// 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
//
//
// num1 和 num2 可以包含前导 0 。
//
//
// 请你返回 num1 和 num2 可以得到的和的 最小 值。
//
// 注意：
//
//
// num 保证没有前导 0 。
// num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
//
//
//
//
// 示例 1：
//
//
//输入：num = 4325
//输出：59
//解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
//
//
// 示例 2：
//
//
//输入：num = 687
//输出：75
//解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
//
//
//
//
// 提示：
//
//
// 10 <= num <= 10⁹
//
//
// Related Topics 贪心 数学 排序 👍 31 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q2578 {

    public int splitNum2(int num) {
        String[] numStrs = String.valueOf(num).split("");
        Arrays.sort(numStrs);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            if (i % 2 == 0) {
                num1.append(numStrs[i]);
            } else {
                num2.append(numStrs[i]);
            }
        }
        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }


    public int splitNum(int num) {
        List<Integer> nums = new ArrayList<>();
        while (num / 10 != 0 || num % 10 != 0) {
            nums.add(num % 10);
            num = num / 10;
        }
        Collections.sort(nums);
        int num1 = nums.get(0);
        int num2 = nums.get(1);

        for (int i = 2; i < nums.size(); i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + nums.get(i);
            } else {
                num2 = num2 * 10 + nums.get(i);
            }
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        //输入：num = 4325
//输出：59
        int num = 25;
        Q2578 q2578 = new Q2578();
        int rs = q2578.splitNum(num);
        System.out.printf("_" + rs);
    }
}
