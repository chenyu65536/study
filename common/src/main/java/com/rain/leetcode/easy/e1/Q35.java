package com.rain.leetcode.easy.e1;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/10/23 5:06 下午
 */
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 722 👎 0
public class Q35 {

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
            if (i + 1 == nums.length) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};

        System.out.printf(""+searchInsert(nums,0));
    }

}
