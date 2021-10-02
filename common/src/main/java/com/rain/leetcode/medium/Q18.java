package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] ：
//
//
// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
//
//
// 你可以按 任意顺序 返回答案 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 双指针 排序 👍 967 👎 0
public class Q18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums.length < 4) {
            return rs;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                int targetTemp = target - nums[i] - nums[j];

                if ((targetTemp > 0 && nums[right] <= 0) || (targetTemp < 0 && nums[left] >= 0)) {
                    continue;
                }

                while (left < right) {

                    int sumLR = nums[left] + nums[right];
                    if (targetTemp == sumLR) {
                        rs.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                     //   System.out.println(String.format("i:%d,j:%d,left:%d,right:%d", i, j, left, right));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    } else if (sumLR > targetTemp) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return rs;
    }


    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2,2};
        //-2,-1,0,0,1,2
        int target = 8;
        List<List<Integer>> rs = Q18.fourSum(nums, target);
        System.out.println("" + rs);

    }

}
