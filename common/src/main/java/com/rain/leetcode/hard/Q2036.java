package com.rain.leetcode.hard;

import java.util.Arrays;

public class Q2036 {

    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        //先按生长时间长降序、然后按照种植时间升序
        int length = plantTime.length;
        Integer[] ids = new Integer[length];
        for (int i = 0; i < length; i++) {
            ids[i] = i;
        }

        Arrays.sort(ids, (a, b) -> {
            if (growTime[b] == growTime[a]) {
                return plantTime[a] - plantTime[b];
            }
            return growTime[b] - growTime[a];
        });

        int max =0,days = 0;
        for (int id :ids) {
            days += plantTime[id];
            max = Math.max(max, days+growTime[id]);
        }
        return max;
    }

    public static void main(String[] args) {
   /*     int[] plantTime = {1};
        int[] growTime = {1};*/

        int[] plantTime = {1,4,3};
        int[] growTime = {2,3,1};
        int rs = earliestFullBloom(plantTime,growTime);
    }
}
