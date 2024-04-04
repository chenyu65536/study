package com.rain.leetcode.easy;
//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 1011 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q350 {

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] num1Count = new int[1001];
        int[] num2Count = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            num1Count[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            num2Count[nums2[i]] += 1;
        }
        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < num1Count.length; i++) {
            for (int j = 0; j < Math.min(num1Count[i], num2Count[i]); j++) {
                rs.add(i);
            }
        }
        int[] finalRs = new int[rs.size()];
        for (int i = 0; i < rs.size(); i++) {
            finalRs[i] = rs.get(i);
        }
        return finalRs;
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> rs = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < nums1.length; i++) {
            for (; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    rs.add(nums1[i]);
                    j++;
                    break;
                }
            }
        }

        int[] finalRs = new int[rs.size()];
        for (int m = 0; m < rs.size(); m++) {
            finalRs[m] = rs.get(m);
        }
        return finalRs;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2};
        Q350 q350 = new Q350();
        int[] rs = q350.intersect(nums1, nums2);
        System.out.printf("11");
    }
}
