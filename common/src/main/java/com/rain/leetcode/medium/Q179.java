package com.rain.leetcode.medium;


import java.util.*;

public class Q179 {

    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) (Double.parseDouble(o2 + "" + o1) - Double.parseDouble(o1 + "" + o2));
            }
        });
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0 && rs.length() == 0) {
                continue;
            }
            rs.append(numbers[i]);
        }
        if(rs.length() == 0){
            rs.append(0);
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        //输入：nums = [10,2]
//输出："210"
//输入：nums = [3,30,34,5,9]
//输出："9534330"
        int[] nums = new int[]{1000000000, 1000000000};
        Q179 q179 = new Q179();
       String rs =  q179.largestNumber(nums);
        System.out.printf("1");
    }

}
