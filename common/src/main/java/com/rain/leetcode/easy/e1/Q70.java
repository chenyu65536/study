package com.rain.leetcode.easy.e1;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1365 👎 0

public class Q70 {

    public static int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] solutions = new int[n];
        solutions[n - 1] = 1;
        solutions[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            //规则
            solutions[i] = solutions[i + 1] + solutions[i + 2];
            if (i == 0) {
                return solutions[0];
            }
        }
        return 0;
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int an_1 = 2;
        int an_2 = 1;
        int result = 0;
        for (int i = n - 3; i >= 0; i--) {
            result = an_1 + an_2;
            an_2 = an_1;
            an_1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        climbStairs(3);
        System.out.printf(""+climbStairs2(4));
    }
}
