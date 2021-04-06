package com.rain.leetcode.medium;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3143 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_X {

    /**
     *
     * 理解有问题
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] distinct = new int[211];
        //桶排序
        for (int i = 0; i < nums.length; i++) {
            distinct[nums[i] + 105] = 1;
        }
        for (int i = 0; i < distinct.length; i++) {
            if (distinct[i] == 1) {
                List<List<Integer>> row = findPair(distinct, 105 - i, i);
                if (row.size() > 0) {
                    result.addAll(row);
                }
            }

        }
        return result;
    }

    private List<List<Integer>> findPair(int[] distinct, int sum, int startIndex) {
        int i = startIndex + 1;//v1=i-105
        int j = sum - startIndex + 209;//sum-v1=v2=j-105
        List<List<Integer>> result = new ArrayList<>();
        while (i < j) {
            if (distinct.length > j) {
                if (distinct[i] == 1 && distinct[j] == 1) {
                    result.add(Arrays.asList(startIndex - 105, i - 105, j - 105));
                }
            }
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        Q15_X q15X = new Q15_X();

        System.out.printf("" + q15X.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
