package com.rain.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q447 {

    public int numberOfBoomerangs(int[][] points) {
        int rs = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distances = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int distance = (int) Math.pow(points[i][0] - points[j][0], 2) + (int) Math.pow(points[i][1] - points[j][1], 2);
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }

            for (Integer key : distances.keySet()) {
                int count = distances.get(key);
                rs += count * (count - 1);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0},
                {1, 0},
                {2, 0}
        };
        Q447 q447 = new Q447();
        int rs = q447.numberOfBoomerangs(points);
        System.out.printf("" + rs);
    }
}
