package com.rain.leetcode.easy;
//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
//
//
// 示例 1：
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
//
//
// 示例 2：
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 9
// 1 <= nums1[i], nums2[i] <= 9
// 每个数组中，元素 互不相同 。
//
//
// Related Topics 数组 哈希表 枚举 👍 64 👎 0

import java.util.Map;

public class Q2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] nums1Flag = new boolean[10];

        int min = Integer.MAX_VALUE;
        int min1 = 9;
        int min2 = 9;
        for (int i = 0; i < nums1.length; i++) {
            nums1Flag[nums1[i]] = true;
            min1 = Math.min(min1, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Flag[nums2[i]]) {
                min = Math.min(min, nums2[i]);
            }
            min2 = Math.min(min2, nums2[i]);
        }
        //查找最新的true
        return Math.min(min, Math.min(min2 * 10 + min1, min1 * 10 + min2));
    }
}
