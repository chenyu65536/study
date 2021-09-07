package com.rain.leetcode.easy;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//
//
// 示例 2：
//
//
//输入：n = 5
//输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 记忆化搜索 数学 动态规划
//0,1,1,2,3,5,8,13
//0,1,1,2,3,5,8,13,21,34,55,89,144,233,377
// 👍 197 👎 0
public class O10 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[]{0,1};
        for (int i = 2; i <= n; i++) {
            int current = nums[0] + nums[1];
            nums[0] = nums[1];
            nums[1] = current % 1000000007;
        }
        return nums[1];
    }

    public static void main(String[] args) {
       // 解答失败: 测试用例:45 测试结果:1134903170 期望结果:134903163 stdout:
        O10 o10 = new O10();
        System.out.printf(""+o10.fib(45));
    }

}
