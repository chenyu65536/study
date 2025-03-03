package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Q3143 {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int length = points.length;
        int[][] newP = new int[length][2];
        for(int i = 0;i<length;i++){
            newP[i] = new int[]{i,getHalfLen(points[i])};
        }
        Arrays.sort(newP, Comparator.comparingInt((int[] a) -> a[1]));

        int res=0;
        boolean[] used = new boolean[26];
        for(int i=0;i<length;i++){
            int idx = s.charAt(newP[i][0])-'a';
            if(used[idx]){
                return res;
            }
            int halfLength = newP[i][1];
            int cnt = 1;
            used[idx]=true;

            while(i+1<length && newP[i+1][1]==halfLength){
                int idx2 = s.charAt(newP[i+1][0])-'a';
                if(used[idx2]){
                    return res;
                }
                used[idx2]=true;
                cnt++;
                i++;
            }
            res+=cnt;;
        }
        return res;
    }

    public int getHalfLen(int[] a){
        return Math.max(Math.abs(a[0]),Math.abs(a[1]));
    }

    public static void main(String[] args) {
        Q3143 q3143 = new Q3143();
        //[[-1,-4],[16,-8],[13,-3],[-12,0]]
        q3143.maxPointsInsideSquare(new int[][]{
                {-1,-4},{16,-8},{13,-3},{-12,0}
        },"abda");
    }

}
