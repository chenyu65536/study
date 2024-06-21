package com.rain.leetcode.hard;

import java.util.*;
import java.util.stream.Stream;

public class Q2589 {
    public int findMinimumTime(int[][] tasks) {
        List<int[]> list = new ArrayList<>();
        int maxEnd = Integer.MIN_VALUE;
        int minStart = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            list.add(task);
            minStart = Math.min(minStart, task[0]);
            maxEnd = Math.max(maxEnd, task[1]);
        }
        list.sort((a, b) -> a[0] - b[0]);

        boolean[] used = new boolean[maxEnd + 1];
        //逐个查找交集
        for (int i = 0; i < list.size(); i++) {
            int[] base = list.get(i);
            //查找交集
            Map<Integer, Integer> sortMap = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                int[] compare = list.get(j);
                if (compare[0] > base[1]) {
                    break;
                }
                for (int m = compare[0] ;m<= compare[1];m++) {
                    if (m >= base[0] && m <= base[1]) {
                        sortMap.put(m, sortMap.getOrDefault(m, 0) + 1);
                    }
                }
            }
            /*{2, 3, 1},
            {4, 5, 1},
            {1, 5, 2}*/
            sortMap = sortByValue(sortMap);
            int useCount = 0;
            for (Integer key : sortMap.keySet()) {
                if (sortMap.get(key) == 0 || useCount == base[2]) {
                    break;
                }
                used[key] = true;
                useCount++;
            }

            //不存在交集
            for (int m = base[0]; m <= base[1]; m++) {
                if (useCount == base[2]) {
                    break;
                }
                if (used[m]) {
                    continue;
                }
                used[m] = true;
                useCount++;
            }
        }
        int rs = 0;
        for (boolean use : used) {
            rs += (use ? 1 : 0);
        }
        return rs;
    }

    public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        Q2589 q2589 = new Q2589();
       /* int[][] tasks = new int[][]{
                {1, 3, 2},
                {2, 5, 3},
                {5, 6, 2}
        };*/

        int[][] tasks = new int[][]{
                {2, 3, 1},
                {4, 5, 1},
                {1, 5, 2}
        };
        int rs = q2589.findMinimumTime(tasks);
        System.out.printf("" + rs);
    }
}
