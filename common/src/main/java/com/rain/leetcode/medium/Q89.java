package com.rain.leetcode.medium;

import java.util.*;

public class Q89 {

    boolean[] used;
    List<Integer>[] memo;

    int n;

    public List<Integer> grayCode(int n) {
        int cnt = (int) Math.pow(2, n);
        this.used = new boolean[cnt];
        this.memo = new ArrayList[cnt];
        this.n = n;
        used[0] = true;
        LinkedList<Integer> res = new LinkedList();
        res.add(0);
        return dfs(cnt - 1, res);
    }

    public LinkedList<Integer> dfs(int left, LinkedList<Integer> row) {
        if (left == 0) {
            //和0进行比较
            int cnt = 0;
            int preVal = row.getLast();
            while (preVal > 0) {
                if (preVal % 2 == 1) {
                    cnt++;
                }
                preVal = preVal >> 1;
            }
            return cnt > 1 ? null : row;
        }
        for (int neighbor : getNeighbors(row.getLast())) {
            used[neighbor] = true;
            row.add(neighbor);
            LinkedList<Integer> rs = dfs(left - 1, row);
            if (rs != null) {
                return rs;
            }
            used[neighbor] = false;
            row.removeLast();
        }
        return null;
    }


    public List<Integer> getNeighbors(int preVal) {
        if (memo[preVal] != null) {
            return memo[preVal];
        }
        List<Integer> neighbors = new ArrayList<>();
        int mask = 1;
        for (int i = 0; i < n; i++) {
            if (!used[preVal ^ mask]) {
                neighbors.add(preVal ^ mask);
            }
            mask = mask << 1;
        }
        memo[preVal] = neighbors;
        return neighbors;
    }

    public static void main(String[] args) {
        Q89 q89 = new Q89();
        List<Integer> res = q89.grayCode(3);
        System.out.printf("" + res);
    }
}
