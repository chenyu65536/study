package com.rain.leetcode.dp;
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 2³¹ - 1
// 0 <= amount <= 10⁴
//
// Related Topics 广度优先搜索 数组 动态规划 👍 1658 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);

        for (int i = 1; i < amount + 1; i++) {
            int rs = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    dp[i] = 1;
                    break;
                }
                if (i - coins[j] < 0) {
                    break;
                }
                //i>coins[j]
                if (dp[i - coins[j]] == -1) {
                    continue;
                }
                rs = Math.min(rs, dp[i - coins[j]] + 1);
                dp[i] = rs;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        Q322 q322 = new Q322();
        int rs = q322.coinChange(coins, amount);

        System.out.printf("" + rs);

    }

}
