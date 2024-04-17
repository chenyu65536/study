package com.rain.leetcode.medium;


import java.util.*;

public class Q924 {

    public static int minMalwareSpread(int[][] graph, int[] initial) {
        List<HashSet<Integer>> connectedblocks = new ArrayList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            HashSet<Integer> block = new HashSet<>();
            block.add(i);
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    continue;
                }
                if (graph[i][j] == 1) {
                    block.add(j);
                    vis[j] = true;
                }
            }
            connectedblocks.add(block);
        }
        // Map<Integer, Integer[]> blockMap = new HashMap<>();
        List<Integer[]> blockData = new ArrayList<>();
        for (int i = 0; i < connectedblocks.size(); i++) {
            //每个连通包含污染节点数量
            int count = 0;
            //每个污染连通最小的污染节点
            int removeNodeIndex = Integer.MAX_VALUE;
            for (int j = 0; j < initial.length; j++) {
                if (connectedblocks.get(i).contains(initial[j])) {
                    count++;
                    removeNodeIndex = Math.min(removeNodeIndex, j);
                }
            }
            if (count > 0) {
                blockData.add(new Integer[]{connectedblocks.get(i).size(), count, removeNodeIndex});
            }
        }
        //sort  污染节点数由小到大，相同再判断连通块数量由大到小
        System.out.printf("_");
        Optional<Integer[]> optional = blockData.stream().filter(item -> item[1] == 1).min((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[2] - o2[2];
            }
        });
        if (optional.isPresent()) {
            return initial[optional.get()[2]];
        }else {
            return initial[0];
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[] initial = new int[]{0, 1};

    /*    graph = new int[][]{
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 1}
        };
        initial = new int[]{1};*/


      /* graph = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        initial = new int[]{0, 1, 2};
*/


   /*     graph = new int[][]{
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,1},
                {0,0,1,1}
        };
        initial = new int[]{3,1};*/


      /*  graph = new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        initial = new int[]{0,2};*/


        graph = new int[][]{
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        initial = new int[]{7,8,6,2,3};

        int node = Q924.minMalwareSpread(graph, initial);
        System.out.printf("" + node);
    }
}
