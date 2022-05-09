package com.rain.leetcode.off;
//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
//
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/
// Related Topics 数组 回溯 👍 20 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Of082 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return rs;
    }

    List<Integer> row = new ArrayList<>();

    private void backTrack(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            rs.add(new ArrayList<>(row));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            row.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        Of082 of082 = new Of082();
        int[] candidates = new int[]{1,1,2,5,6,7,10};
        int target = 8;
        //输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
        List<List<Integer>> rs = of082.combinationSum2(candidates, target);
        System.out.printf("11");
    }
}
