package com.rain.leetcode.easy;
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
//
//示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
// Related Topics 数组 二分查找
// 👍 364 👎 0
public class Q704 {

    public int search(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length-1;
        while (right > left) {
            if (right - left == 1) {
                if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      int[]  nums = new int[]{-1,0,3,5,9,12};
      int target = 12;
        Q704 q704 = new Q704();
        int index = q704.search(nums,target);

        System.out.println(""+index);

    }

}
