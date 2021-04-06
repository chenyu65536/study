package com.rain.leetcode.medium;

//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
// 注意：n 的值小于15000。
//
// 示例1:
//
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//
//
// 示例 2:
//
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//
//
// 示例 3:
//
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
//
// Related Topics 栈
// 👍 314 👎 0
public class Q456 {


    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        //假定num[index]为2
        int leftMin = 0;
        for (int i = 1; i < nums.length; i++) {
            leftMin = nums[leftMin] > nums[i - 1] ? i - 1 : leftMin;
            int rightMax = findMax(nums, i, leftMin);
            if (rightMax != -1) {
                return true;
            }
        }
        return false;
    }


    public int findMax(int[] nums, int startIndex, int leftMin) {
        for (int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[leftMin] && nums[i] < nums[startIndex]) {
                return i;
            }
        }
        return -1;
    }


    public boolean find132patternV2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        //假定num[index]为2
        int leftMin = 0;
        for (int i = 1; i < nums.length; i++) {
            leftMin = nums[leftMin] > nums[i - 1] ? i - 1 : leftMin;


            int rightMax = findMax(nums, i, leftMin);
            if (rightMax != -1) {
                return true;
            }
        }
        return false;
    }


    public int findMaxV2(int[] nums, int startIndex, int leftMin) {
        int lastIndex = -1;
        for (int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[leftMin] && nums[i] < nums[startIndex]) {
                if (lastIndex == -1 || nums[i] > nums[lastIndex]) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        Q456 q = new Q456();
        System.out.printf("" + q.find132pattern(new int[]{1, -4, 2, -1, 3, -3, -4, 0, -3, -1}));
    }
}
