package com.rain.leetcode.medium;
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。
//
//
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//
// 示例 2：
//
//
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//
//
// 提示：
//
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// prerequisites[i] 中的所有课程对 互不相同
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1677 👎 0

import java.util.*;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Set<Integer> finish = new HashSet<>();
        Queue<Integer> unfinish = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (graph[i].isEmpty()) {
                finish.add(i);
            } else {
                unfinish.offer(i);
            }
        }
        int k = unfinish.size();
        while (k > 0 && !unfinish.isEmpty()) {
            int count = unfinish.size();
            while (count > 0) {
                int c = unfinish.poll();
                if (finish.containsAll(graph[c])) {
                    finish.add(c);
                } else {
                    unfinish.offer(c);
                }
                count--;
            }
            k--;
        }
        return finish.size() == numCourses;
    }


    public static void main(String[] args) {
        int numCourses = 7;
        //0,1],[3,1],[1,3],[3,2
        //int[][] prerequisites = new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}};
        // int[][] prerequisites = new int[][]{{1,0}};
        // int[][] prerequisites = new int[][]{{0, 1}, {0, 2}, {1, 2}};
       // int[][] prerequisites = new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
       // int[][] prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int[][] prerequisites = new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        Q207 q207 = new Q207();
        boolean rs = q207.canFinish(numCourses, prerequisites);
        System.out.printf("" + rs);
    }
}
