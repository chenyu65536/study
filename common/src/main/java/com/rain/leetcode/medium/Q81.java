package com.rain.leetcode.medium;


//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums
//[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
//2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 targ
//et ，则返回 true ，否则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
//
//
// 示例 2：
//
//
//输入：nums = [2,5,6,0,0,1,2], target = 3->
//输出：false
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -104 <= target <= 104
//
//
//
//
// 进阶：
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 357 👎 0
public class Q81 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int maxIndex = searchMaxIndex(nums);
        int minIndex = searchMinIndex(nums, maxIndex);

        if (target > nums[maxIndex] || target < nums[minIndex]) {
            return false;
        }
        boolean result = false;
        //在左侧
        if (target >= nums[minIndex] && target < nums[0]) {

            result = search(nums, target, minIndex, nums.length - 1);
        } else {
            //在右侧
            result = search(nums, target, 0, maxIndex);
        }

        //查找最大值
        return result;
    }


    //查找最大值
    public boolean search(int[] nums, int target, int left, int right) {

        if (nums[left] == target || nums[right] == target) {
            return true;
        }

        while (true) {
            if (nums[left] > target || nums[right] < target || right - left == 1) {
                return false;
            }
            int midIndex = (left + right) / 2;
            if (nums[midIndex] == target) {
                return true;
            }
            if (nums[left] > target || nums[right] < target) {
                return false;
            }
            if (nums[midIndex] > target) {
                //往后找
                right = midIndex;
            } else {
                //往前找
                left = midIndex;
            }
        }
    }

    public int searchMaxIndex(int[] nums) {
        if (nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    //查找最小值
    public int searchMinIndex(int[] nums, int maxIndex) {
        int max = nums[maxIndex];
        for (int i = maxIndex + 1; i < nums.length; i++) {
            if (nums[i] < max) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //
        //  int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        //[2,5,6,0,0,1,2] 3
        // int[] nums = new int[]{4, 5, 6, 6, 7, 0, 1, 2, 4, 4};
        // int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        // int[] nums = new int[]{1, 0, 1, 1, 1};
        //int[] nums = new int[]{1,3};
        int[] nums = new int[]{1};
        Q81 q81 = new Q81();
        // boolean exist = q81.search(nums,1,0,4);
        // int index = q81.searchMinIndex(nums, 4);
        //  int index = q81.searchMaxIndex(nums);
        boolean exsit = q81.search(nums, 1);
        System.out.println("" + exsit);
        //  System.out.println("" + result);

    }
}
