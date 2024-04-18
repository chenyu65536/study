package com.rain.leetcode.medium;

public class Q2789 {
    public long maxArrayValue(int[] nums) {
        boolean[] deleted = new boolean[nums.length];
        long rs = 0;
        while (true) {
            int pre = -1;
            boolean isFinished = true;
            for (int i = 0; i < nums.length; i++) {
                if (deleted[i]) {
                    continue;
                }
                if (pre == -1 || nums[i] < nums[pre]) {
                    pre = i;
                    continue;
                }
                if (nums[i] >= nums[pre]) {
                    deleted[pre] = true;
                    nums[i] = nums[pre] + nums[i];
                    pre = i;
                    isFinished = false;
                }
                rs = Math.max(rs, nums[i]);
            }
            if(isFinished){
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2789 q2789 = new Q2789();
        int[] nums = {34,95,50,12,25,100,21,3,25,16,76,73,93,46,18};
        System.out.println(q2789.maxArrayValue(nums));
    }
}
