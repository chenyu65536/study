package com.rain.leetcode.hard;

//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变
//化后可能得到：
//
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
// 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
//
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
//..., a[n-2]] 。
//
// 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,5]
//输出：1
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,0,1]
//输出：0
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
//
//
//
//
// 进阶：
//
//
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 310 👎 0
public class Q154 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return Math.min(nums[0], nums[mid]);
            }
            if (right - mid == 1) {//right=mid
                return Math.min(nums[0], nums[right]);
            }

            if (nums[mid] > nums[0]) {//左边分支
                left = mid;
            } else if (nums[mid] < nums[0]) {//右边分支
                right = mid;
            } else if (nums[mid] == nums[0]) {
                //既可能在左边分支也可能在右边分支
                //当在右边分支应为右侧最大值
                if (nums[mid] > nums[nums.length - 1]) {
                    //mid在右侧分支,min在右侧分支
                    left = mid;
                } else if (nums[mid] < nums[nums.length - 1]) {
                    return nums[0];
                } else if (nums[mid] == nums[nums.length - 1]) {
                    //mid要么是最大值，要么是最小值
                    int min = 5001;
                    for (int i = 0; i < nums.length; i++) {
                        if (nums[i] < min) {
                            min = nums[i];
                        }
                    }
                    return min;
                }
            }
        }
    }

    public static void main(String[] args) {
        //[0,1,4,4,5,6,7]
        //  int[] nums = new int[]{4,5,6,7,0,1,4};
        // int[] nums = new int[]{10,1,10,10,10};
        //2,2,2,0,1
        int[] nums = new int[]{2, 2, 2, 0, 1};

        Q154 q154 = new Q154();
        int min = q154.findMin(nums);
        System.out.printf("" + min);

    }
}
