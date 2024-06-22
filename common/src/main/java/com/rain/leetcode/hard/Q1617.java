package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Q1617 {
    List<Integer>[] graph;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] rs = new int[n - 1];
        for (int len = 1; len < n; len++) {
            int wayCount = 0;
            for (int node = 1; node <= n; node++) {
                count=0;
                findWay(node, len);

                wayCount+=count;
            }
            rs[len - 1] = wayCount;
        }
        return rs;
    }


    int count = 0;
    public void findWay(int startNode, int len) {
        if (len == 0) {
             count++;
             return;
        }

        for (int node : graph[startNode]) {
            // 只找比它大的节点，防止循环
            if (node <= startNode) {
                continue;
            }
            findWay(node, len - 1);
        }
    }

    public static void main(String[] args) {
        Q1617 q1617 = new Q1617();
        q1617.countSubgraphsForEachDiameter(4, new int[][]{{1,2},{2,3},{2,4}});
    }
}
