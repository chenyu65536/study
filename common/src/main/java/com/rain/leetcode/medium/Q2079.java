package com.rain.leetcode.medium;

public class Q2079 {
    public static int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int leftWater = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (leftWater < plants[i]) {
                leftWater = capacity;
                steps += i * 2;
            }
            steps++;
            leftWater -= plants[i];
        }
        return steps;

    }

    public static void main(String[] args) {
        int[] plants = new int[]{2,2,3,3};
        int rs = wateringPlants(plants,5);
        System.out.printf("11");
    }
}
