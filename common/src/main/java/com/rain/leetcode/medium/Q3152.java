package com.rain.leetcode.medium;

public class Q3152 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int length = nums.length;
        int[] dp = new int[length];

        for(int i=1;i<length;i++){
            // if((nums[i]%2)!=(nums[i-1]%2)){
            //     dp[i]=dp[i-1];
            // } else {
            //     dp[i]=dp[i-1]+1;
            // }

            dp[i]=dp[i-1]+(((nums[i] ^ nums[i - 1]) & 1)^1);
        }

        boolean[] rs = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            rs[i] = dp[query[1]]==dp[query[0]];

        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,1,6};
        int[][] queries = {{2,3}};
        Q3152 q3152 = new Q3152();
        q3152.isArraySpecial(nums,queries);

    }
}
