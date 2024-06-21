package com.rain.leetcode.medium;

import java.util.Arrays;

public class Q416 {
    int[] nums;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        return dfs(total / 2, new boolean[nums.length]);
    }

    public boolean dfs(int target, boolean[] visited) {
        if (target == 0) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            visited[i] = true;
            if (dfs(target - nums[i], visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Q416 q416 = new Q416();
        boolean rs = q416.canPartition(new int[]{1, 5, 11, 5});
        //boolean rs = q416.canPartition(new int[]{3, 3, 3, 4, 5});
        System.out.printf("" + rs);

    }
}
