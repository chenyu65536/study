package com.rain.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
//
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
// 示例 4：
//
//
//输入: candidates = [1], target = 1
//输出: [[1]]
//
//
// 示例 5：
//
//
//输入: candidates = [1], target = 2
//输出: [[1,1]]
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯 👍 1558 👎 0

public class Q39 {

    List<List<Integer>> rs = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return rs;
    }


    public void backTracking(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            rs.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i);

            if (path.size() > 0) {
                sum = sum - path.get(path.size() - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q39 q39 = new Q39();
        int[] candidates = new int[]{2, 7, 6, 3, 5, 1};
        int target = 9;

        List<List<Integer>> rs = q39.combinationSum(candidates, target);

        System.out.printf("" + rs.toString());
    }
}
