package com.rain.leetcode.easy;

public class Q1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        int times = 0;
        int left = candies;
        int need = (1 + num_people) * num_people / 2;
        while (left >= need) {
            left -= need;
            times++;
            need = need + num_people * num_people;
        }

        int[] rs = new int[num_people];
        if (times > 0) {
            for (int i = 0; i < num_people; i++) {
                rs[i] = (times - 1) * times * num_people / 2 + times * (i + 1);
            }
        }

        for (int i = 0; i < num_people; i++) {
            int add = Math.min(times * num_people + i + 1, left);
            rs[i] += add;
            left -= add;
        }
        return rs;
    }

    public static void main(String[] args) {
        distributeCandies(60, 4);
    }
}
