package com.rain.leetcode.medium;

public class Q3011 {

     public static boolean canSortArray(int[] nums) {
             int length = nums.length;
             int[] cnts = new int[length];
             for (int i = 0; i < length; i++)
                 cnts[i] = getOneCount(nums[i]);

             int preMax = nums[0],currentMax = nums[0];

             int idx = 0;
             for (int i = 1 ; i < length; i++) {
                 if (cnts[i] == cnts[i - 1]) {
                     if(idx >0 && nums[i]<preMax){
                         return false;
                     }
                     currentMax = Math.max(currentMax, nums[i]);
                 } else {
                     if(idx >0 && nums[i]<preMax){
                         return false;
                     }
                     idx++;
                     preMax = currentMax;
                     currentMax = nums[i];
                 }
             }
             return true;
    }

    public static int getOneCount(int num) {
        int rs = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                rs++;
            }
            num = num >> 1;
        }
        return rs;
    }

    public static void main(String[] args) {
       // System.out.println(""+getOneCount(2));
        //System.out.println(""+getOneCount(3));

        canSortArray(new int[]{3,16,8,4,2});
    }
}
