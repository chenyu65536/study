package com.rain.leetcode.easy.e1;


import java.util.Random;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 870 👎 0
public class Q169 {

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int number = getRandom(nums);
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == number) {
                    count++;
                }
                if (count >nums.length / 2) {
                    return number;
                }
            }
        }
        return 0;
    }

    private static int getRandom(int[] nums) {
        //return 2;
        return nums[(new Random().nextInt(nums.length - 1))];
    }

    public static void main(String[] args) {
        int val = majorityElement(new int[]{3, 2, 3});
        System.out.printf("11");

    }

}
