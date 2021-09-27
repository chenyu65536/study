package com.rain.leetcode.easy;

import java.util.*;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 416 👎 0
public class Q349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        Set<Integer> rs = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (s1.contains(nums2[i])) {
                rs.add(nums2[i]);
            }
        }
        int[] rs2 = new int[rs.size()];
        int index = 0;
        for (Integer key : rs) {
            rs2[index] = key;
            index++;
        }
        return rs2;
    }

    public static void main(String[] args) {
        Set<Integer> rs = new HashSet<>();
        rs.add(1);

        rs.add(10);
        rs.add(8);
        rs.add(11);

        rs.add(20);
        rs.add(23);
        rs.add(5);
        rs.add(2);

        System.out.printf("11");
    }

}
