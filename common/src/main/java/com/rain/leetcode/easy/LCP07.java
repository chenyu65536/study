package com.rain.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCP07 {

    public static int numWays(int n, int[][] relation, int k) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < relation.length; i++) {
            graph[relation[i][0]].add(relation[i][1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        int rs = 0;
        int cnt = 0;
        while (k >= 0) {
            cnt = queue.size();
            while (!queue.isEmpty() && cnt > 0) {
                int next = queue.poll();
                if (next == n - 1 && k == 0) {
                    rs++;
                }
                for (int poi : graph[next]) {
                    queue.offer(poi);
                }
                cnt--;
            }
            k--;
        }
        //[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]
        return rs;
    }

    public static void main(String[] args) {
        int[][] relation = new int[][]{
                {0, 2},
                {2, 1},
                {3, 4},
                {2, 3},
                {1, 4},
                {2, 0},
                {0, 4}
        };

        int rs = numWays(5, relation, 3);
        System.out.printf("" + rs);
    }
}
