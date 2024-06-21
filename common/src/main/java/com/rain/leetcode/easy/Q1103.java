package com.rain.leetcode.easy;

public class Q1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int times = 0;
        int left = candies;
        int total = (1 + num_people) / 2 * num_people;
        while (left > total) {
            //1 ~num
            //1 ~ num +n*num_people
            left -= total;
            times++;
            total = total + times * num_people;
        }

        int[] rs = new int[num_people];
        if (times > 0) {
            for (int i = 0; i < num_people; i++) {
                rs[i] = (times + 1) / 2 * (times - 1) * num_people;
            }
        }
        for (int i = 0; i < num_people; i++) {
            int add = i + 1 + times * num_people;
            if (left >= add) {
                rs[i] += add;
            } else {
                rs[i] += left;
                break;
            }
            left -= add;
        }
        return rs;
    }

    public static void main(String[] args) {
        Q1103 q1103 = new Q1103();
        // int[] rs = q1103.distributeCandies(60, 4);
        //int[] rs = q1103.distributeCandies(7, 4);
        int[] rs = q1103.distributeCandies(60, 4);
        System.out.printf("11");
    }

}
