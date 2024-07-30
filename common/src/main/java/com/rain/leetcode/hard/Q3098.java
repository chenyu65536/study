package com.rain.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3098 {

    int[] nums;
    int mod = (int) 1e9 + 7;
    private Map<Long, Integer> memo = new HashMap<>();


    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);//最小值出现在相邻的2个节点
        this.nums = nums;
        return dfs(0, nums.length, k,Integer.MAX_VALUE);
    }


    public int dfs(int i, int j, int k, int mi) {
        if (i >= nums.length) {
            return k == 0 ? mi : 0;
        }

        if (nums.length - i < k) {
            return 0;
        }

        long key = (1L * mi) << 18 | (i << 12) | (j << 6) | k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        //不选
        int ans = dfs(i + 1, j, k, mi);

        if (j == nums.length) {
            ans += dfs(i + 1, i, k-1, mi);
        } else {
            ans += dfs(i + 1, i, k-1, Math.min(mi, nums[i] - nums[j]));
        }
        ans %= mod;
        memo.put(key,ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-24, -921, 119, -291, -65, -628, 372, 274, 962, -592, -10, 67, -977, 85, -294, 349, -119, -846, -959, -79, -877, 833, 857, 44, 826, -295, -855, 554, -999, 759, -653, -423, -599, -928};
        Q3098 q3098 = new Q3098();
        System.out.println(q3098.sumOfPowers(nums, 19));
        String s = "";
    }
}
