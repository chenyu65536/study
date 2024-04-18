package com.rain.leetcode.medium;


import java.util.Arrays;

public class LCR103 {

    public static int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, -1);
        Arrays.sort(coins);
        count[0] = 0;
        for (int target = 1; target <= amount; target++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int index = target - coins[i];
                if (index < 0) {
                    break;
                }
                if (count[index] == -1) {
                    continue;
                }
                min = Math.min(count[index] + 1, min);
                count[target] = min;
            }
        }
        return count[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        int rs = coinChange(coins, amount);
        System.out.printf("" + rs);
    }
}
