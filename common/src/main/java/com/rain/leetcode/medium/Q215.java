package com.rain.leetcode.medium;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2266 👎 0

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        int[] newNums = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] + 10000;
            newNums[index]++;
        }
        int count = 0;
        for (int i = newNums.length - 1; i > -1; i--) {
            count += newNums[i];
            if (count >= k) {
                return i - 10000;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        Q215 q215 = new Q215();
        int rs = q215.findKthLargest(nums, 4);
        System.out.printf(""+rs);
    }
}
