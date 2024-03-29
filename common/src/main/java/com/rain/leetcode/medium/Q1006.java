package com.rain.leetcode.medium;
//通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 *
// 3 * 2 * 1。
//
// 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)
//和减法(-)。
//
// 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我
//们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
//
// 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
//
// 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
//
//
//
// 示例 1：
//
// 输入：4
//输出：7
//解释：7 = 4 * 3 / 2 + 1
//
//
// 示例 2：
//
// 输入：10
//输出：12
//解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10000
// -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。）
//
// Related Topics 数学
// 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q1006 {

    public int clumsy(int N) {
        int result = 0;
        int times = N / 4;
        int base = N;
        if (times > 0) {
            result = base * (base - 1) / (base - 2) + (base - 3);
        }

        for (int i = 1; i < times; i++) {
            base = base - 4;
            result -= base * (base - 1) / (base - 2) - (base - 3);
        }
        //处理余数 4*3/2+1
        int mod = N % 4;
        int subResult = 0;
        if (mod == 1) {
            subResult = 1;
        } else if (mod == 2) {
            subResult = 2;//2 * 1;
        } else if (mod == 3) {
            subResult = 6;//3 * 2 / 1;
        }
        return result + (N / 4 > 0 ? -1 * subResult : subResult);
    }

    public static void main(String[] args) {
        // 解答失败: 测试用例:10 测试结果:16 期望结果:12 stdout:
        Q1006 q1006 = new Q1006();
        int result = q1006.clumsy(10);
        System.out.printf("" + result);
    }
}
