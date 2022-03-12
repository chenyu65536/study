package com.rain.leetcode.math;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 👍 1518 👎 0

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                if (nums[mid] == target) {
                    index = mid;
                } else if (nums[right] == target) {
                    index = right;
                }
                break;
            }
            if (nums[mid] == target) {
                index = mid;
                break;
            }

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        }

        left = index;
        right = index;
        while (left >=0 && nums[left] == target) {
            left--;
        }
        while (right != nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;

        //[5,7,7,8,8,10] 6
        Q34 q34 = new Q34();
        int[] rs = q34.searchRange(nums, target);
        System.out.printf("111");
    }
}
