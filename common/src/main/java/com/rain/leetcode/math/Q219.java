package com.rain.leetcode.math;
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,1], k = 3
//输出：true
//
// 示例 2：
//
//
//输入：nums = [1,0,1,1], k = 1
//输出：true
//
// 示例 3：
//
//
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
//
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// 0 <= k <= 10⁵
//
// Related Topics 数组 哈希表 滑动窗口 👍 465 👎 0


import java.util.LinkedHashSet;

public class Q219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        LinkedHashSet<Integer> values = new LinkedHashSet<>();

        for (int i = 0; i <= k && i < nums.length; i++) {
            if (values.contains(nums[i])) {
                return true;
            }
            values.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; i++) {
            if (values.contains(nums[i]) && nums[i - k - 1] != nums[i]) {
                return true;
            }
            values.remove(values.stream().findFirst().get());
            values.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        //[1,2,3,1], k = 3
        //
        //输入：nums = [1,2,3,1,2,3], k = 2
        //输出：false
        //
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        Q219 q219 = new Q219();
        boolean rs = q219.containsNearbyDuplicate(nums, k);
        System.out.printf("" + rs);
    }
}
