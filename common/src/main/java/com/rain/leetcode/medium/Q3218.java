package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3218 {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int hIdx = m - 2,vIdx = n - 2,res = 0;
        while (hIdx >=0 || vIdx >=0) {
            int cost1 = Integer.MIN_VALUE,cost2=Integer.MIN_VALUE;
            if(hIdx >=0){
                cost1 = horizontalCut[hIdx];
            }
            if(vIdx >=0){
                cost2 = verticalCut[vIdx];
            }

            if(cost1>cost2){
                res+=cost1*(n-1-vIdx);
                hIdx--;
            } else {
                res+=cost2*(m-1-hIdx);
                vIdx--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "22";
        Integer.toBinaryString(Integer.parseInt(s));
    }

}
