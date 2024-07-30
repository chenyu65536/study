package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3112 {
    Map<Integer,Integer>[] graph;
    int[] disappear;
    int[] res;
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.disappear = disappear;
        this.graph = new HashMap[n];
        this.res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);

        for(int i=0;i<n;i++) graph[i] = new HashMap();

        for(int[] edge:edges){
            int from = edge[0],to = edge[1],len = edge[2];
            //from->to 可能存在多条路径，只保留最短路径
            graph[from].put(to,Math.min(graph[from].getOrDefault(to,Integer.MAX_VALUE),len));
            graph[to].put(from,Math.min(graph[to].getOrDefault(from,Integer.MAX_VALUE),len));
        }

        for(int i=0;i<n;i++){
            res[i] = dfs(0,i,0);
        }

        for(int i=0;i<n;i++){
            if(res[i]==Integer.MAX_VALUE){
                res[i]=-1;
            }
        }
        return res;
    }

    public int dfs(int from,int to,int time){
        if(from == to){
            return time;
        }

        Map<Integer,Integer> neighbors = graph[from];
        int rs = Integer.MAX_VALUE;
        for(int neighbor:neighbors.keySet()){
            int totalCost = neighbors.get(neighbor)+time;
            if(totalCost>=disappear[neighbor] || totalCost>res[neighbor]){
                continue;
            }
            rs = Math.min(dfs(neighbor,to,totalCost),rs);
        }
        return rs;
    }

    public static void main(String[] args) {
        Q3112 q3112 = new Q3112();
        q3112.minimumTime(3, new int[][]{{0,1,2},{1,2,1},{0,2,4}},new int[]{1,3,5});
    }
}
