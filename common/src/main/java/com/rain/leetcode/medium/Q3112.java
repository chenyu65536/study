package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3112 {

    int[] disappear;
    Map<Integer, Integer>[] graph;
    int[] res;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.graph = new HashMap[n];
        this.disappear = disappear;
        for (int i = 0; i < n; i++) graph[i] = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
            graph[from].put(to, Math.min(cost, graph[from].getOrDefault(to, Integer.MAX_VALUE)));
            graph[to].put(from, Math.min(cost, graph[to].getOrDefault(from, Integer.MAX_VALUE)));
        }
        res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;

        for (int i = 0; i < n; i++) {
            // vis[0] = true;
            res[i] = dfs(0, i, 0, new boolean[n]);
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }

    public int dfs(int from, int to, int time, boolean[] vis) {
        if (to == from) {
            return time;
        }
        if (res[to] != Integer.MAX_VALUE) {
            return res[to];
        }
        int rs = Integer.MAX_VALUE;
        Map<Integer, Integer> neighbors = graph[to];
        for (Integer neighbor : neighbors.keySet()) {
            int cost = neighbors.get(neighbor);
            if (vis[neighbor] || disappear[to] <= time + cost) {
                continue;
            }
            vis[neighbor] = true;
            int total = dfs(from, neighbor, neighbor, vis);
            if (total == Integer.MAX_VALUE) {
                continue;
            }
            rs = Math.min(total + cost, rs);
        }
        return rs;
    }

    public static void main(String[] args) {
        Q3112 q3112 = new Q3112();
    }
}
