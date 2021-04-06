package com.rain.leetcode.easy.e1;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/12/3 3:20 下午
 */
//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//解答成功: 执行耗时:2 ms,击败了57.66% 的Java用户 内存消耗:35.8 MB,击败了54.98% 的Java用户
// Related Topics 数学 二分查找
// 👍 551 👎 0
public class Q69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        long top = x;
        long bottom = 0;
        while (true) {
            long mid = (top + bottom) / 2;
            if (top - bottom == 1) {
                return (int) mid;
            }
            if (mid * mid > x) {
                top = mid;
            } else {
                bottom = mid;
            }
        }
    }
}
