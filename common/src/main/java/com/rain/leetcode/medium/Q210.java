package com.rain.leetcode.medium;

import java.util.*;

public class Q210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //parent->child
        // parent->child
        Map<Integer, List<Integer>> pc = new HashMap();
        Map<Integer, Integer> cp = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            pc.put(i, new ArrayList());
            cp.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            pc.get(pre[1]).add(pre[0]);// 后置节点
            cp.put(pre[0], cp.get(pre[0]) + 1);// 前置节点个数
        }
        int[] rs = new int[numCourses];
        Arrays.fill(rs, -1);
        int j = 0;
        for (int i = 0; i < numCourses; i++) {
            if (cp.get(i) == 0) {// 前置课程为空
                rs[j] = i;
                j++;
            }
        }

        for (int i = 0; i < j; i++) {
            List<Integer> nexts = pc.get(rs[i]);
            for (Integer next : nexts) {
                cp.put(next, cp.get(next) - 1);// 前置节点个数
                if (cp.get(i) == 0) {
                    rs[j] = next;
                    j++;
                }
            }
        }
        if (j == numCourses) {
            return rs;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
      //  findOrder(2, new int[][]{{1, 0}});
        findOrder(1, new int[][]{});
        Stack<String> stack = new Stack();

    }
}
