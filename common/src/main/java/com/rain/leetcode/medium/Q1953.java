package com.rain.leetcode.medium;

import java.util.PriorityQueue;

public class Q1953 {
    public long numberOfWeeks(int[] milestones) {
        if (milestones.length == 1) {
            return 1;
        }
        if (milestones.length == 2) {
            return Math.min(milestones[0], milestones[1]) + 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int m : milestones) {
            queue.offer(m);
        }
        //5,7,5,7,9,7
        //9,7,7,7,5,5
        //7,7,5,5，2=>14
        //5,5,2=>28
        //2=>

        //9,3,6,8,2,1
        //9,8,6,3,2,1
        //6,3,2,1，1 =》16
        //3.2.1.1=>22
        //1.1.1=>26
        int weeks = 0;
        while (queue.size() > 1) {
            int m1 = queue.poll();
            int m2 = queue.poll();
            weeks += m2 * 2;
            if (m1 - m2 > 0) {
                queue.offer(m1 - m2);
            }
        }

        if (!queue.isEmpty()) {
            weeks += 1;
        }
        return weeks;
    }

    public static void main(String[] args) {
        int[] milestones = new int[]{
                5, 2, 1
        };
        milestones = new int[]{
                5, 7, 5, 7, 9, 7
        };
        Q1953 q1953 = new Q1953();
        long rs = q1953.numberOfWeeks(milestones);
        System.out.printf("" + rs);
    }
}
