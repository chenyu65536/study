package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Q699 {

    public static List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList();
        List<int[]> height = new  ArrayList();
        int preH = 0;
        for(int i=0;i<positions.length;i++){
            int idx = positions[i][0], width = positions[i][1];
            //查找 idx~width 的高度
            int h = 0;
            for(int j=0;j<height.size();j++){
                int[] pre = height.get(j);
                if((pre[0]<=idx && idx<pre[1])
                        || (pre[0]<idx+width && idx+width<=pre[1])
                        || (idx<=pre[0] && pre[1]<=idx+width)){
                    h = Math.max(h,pre[2]);
                }
            }
            h+=positions[i][1];
            height.add(new int[]{idx,idx+width,h});
            preH = Math.max(h,preH);
            res.add(preH);
        }
        return res;
    }

    public static void main(String[] args) {
        fallingSquares(new int[][]{
                {1, 5}, {2, 2}, {7, 5}
        });
    }
}
