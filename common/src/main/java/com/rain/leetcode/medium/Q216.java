package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216 {

    private int k;
    private int n;
    List<List<Integer>> rs;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        rs = new ArrayList<>();
        dfs(new LinkedList<>(), 1, 0);
        return rs;
    }


    public void dfs(List<Integer> items, int start, int sum) {
        if (items.size() == k && sum == n) {
            rs.add(new ArrayList<>(items));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (sum + i > n) {
                break;
            }
            items.add(i);
            dfs(items, i + 1, sum + i);
            items.remove(items.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q216 q216 = new Q216();
        List<List<Integer>> rs = q216.combinationSum3(3, 9);
        System.out.printf("" + rs);
    }
}
