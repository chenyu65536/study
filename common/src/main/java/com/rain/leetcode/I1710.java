package com.rain.leetcode;

import java.util.HashMap;

//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。
//
//
//
// 示例 1：
//
//
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5
//
// 示例 2：
//
//
//输入：[3,2]
//输出：-1
//
// 示例 3：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
// Related Topics 数组 计数
// 👍 184 👎 0
public class I1710 {

    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxKey = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currentKey = nums[i];
            int total = count.get(currentKey) == null ? 1 : count.get(currentKey) + 1;
            count.put(currentKey, total);

            maxKey = count.get(maxKey) > total ? maxKey : currentKey;
        }
        return count.get(maxKey) > nums.length / 2 ? maxKey : -1;
    }

    public static void main(String[] args) {
        I1710 i1710 = new I1710();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int max =  i1710.majorityElement(nums);
        System.out.printf(""+max);
    }
}
