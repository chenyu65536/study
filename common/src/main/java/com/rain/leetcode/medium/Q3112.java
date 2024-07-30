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
        res[to] = rs;
        return rs;
    }

    public static void main(String[] args) {
        Q3112 q3112 = new Q3112();
       /* q3112.minimumTime(8,
                new int[][]{{4, 0, 5}, {3, 7, 3}, {0, 2, 3}, {3, 5, 3}, {7, 0, 1}, {2, 0, 3}, {7, 7, 10}},
                new int[]{15, 8, 4, 3, 9, 18, 9, 13}
        );*/


    /*    q3112.minimumTime(3,
                new int[][]{{2, 0, 9}, {1, 0, 5}, {2, 2, 4}, {0, 1, 10}, {1, 1, 10}, {1, 1, 10}, {2, 2, 10}, {1, 1, 10}},
                new int[]{4, 13, 19}
        );*/


      /*  q3112.minimumTime(4,
                new int[][]{{2, 3, 8}, {2, 0, 9}, {3, 0, 8}, {2, 1, 6}, {2, 1, 3}},
                new int[]{10, 6, 16, 19}
        );*/

      q3112.minimumTime(3,
                new int[][]{
                        {0, 1, 2}, {1, 2, 1},
                        {0, 2, 4}},
                new int[]{1, 1, 5}
        );
    }
}
