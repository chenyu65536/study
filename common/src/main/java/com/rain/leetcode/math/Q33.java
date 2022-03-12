package com.rain.leetcode.math;
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找 👍 1902 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q33 {

    public int search(int[] nums, int target) {
        int minIndex = searchMinIndex(nums);
        if (nums[minIndex] > target || nums[minIndex == 0 ? nums.length - 1 : minIndex - 1] < target) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        if (nums[minIndex] <= target && nums[nums.length - 1] >= target) {
            left = minIndex;
        } else {
            right = minIndex;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }

    public int searchMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[nums.length - 1] > nums[0]) {
            return 0;
        }
        //查找最小的位置
        while (right >= left) {
            int mid = (left + right) / 2;
            //4,5,6,7,0,1,2
            if (mid == left) {
                return nums[left] < nums[right] ? left : right;
            }
            if (nums[mid] <= nums[0] && nums[mid] <= nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < nums[0]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                left = mid;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        // [4,5,6,7,0,1,2], target = 0
        int[] nums = new int[]{1, 3, 5};
        int target = 1;
        Q33 q33 = new Q33();
        int index = q33.search(nums, target);
        System.out.printf("" + index);
    }
}
