package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class I0811 {


    public static int waysToChange(int n) {
        int MOD = 1000000007;
        int[] coins = {25, 10, 5, 1};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int rs = I0811.waysToChange(61);
        System.out.printf("" + rs);
        List<String> rs2  = new ArrayList<>();
        String[] y = rs2.toArray(new String[rs2.size()]);
    }
}
