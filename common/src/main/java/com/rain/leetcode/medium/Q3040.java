package com.rain.leetcode.medium;

public class Q3040 {

    public int maxOperations(int[] nums) {
        int length = nums.length;
        return Math.max(
                Math.max(sum(nums, 0, length - 1, nums[0] + nums[1]),
                        sum(nums, 0, length - 1, nums[length - 1] + nums[length - 2])),
                sum(nums, 0, length - 1, nums[0] + nums[length - 1]));
    }

    public int sum(int[] nums, int i, int j, int target) {
        if(i>=j){
            return 0;
        }
        int rs = 0;
        if (i < j &&nums[i] + nums[i + 1] == target) {
            rs = sum(nums, i + 2, j, target) + 1;
        }
        if (i < j && nums[j] + nums[j - 1] == target) {
            rs = Math.max(rs, sum(nums, i, j - 2, target) + 1);
        }
        if (i < j && nums[i] + nums[j] == target) {
            rs = Math.max(rs, sum(nums, i + 1, j - 1, target) + 1);

        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,2,3,4};
        Q3040 q3040 = new Q3040();
        q3040.maxOperations(nums);
    }
}
