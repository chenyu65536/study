package com.rain.leetcode.medium;

public class Q1977 {


    public static long firstDayBeenInAllRooms(int[] nextVisit) {
        int visitedNum = 0;
        long[] visitTimes = new long[nextVisit.length];
        int nextPostion = 0;
        long days = 0;
        while (true) {
            visitTimes[nextPostion]++;
            if (visitTimes[nextPostion] == 1) {
                visitedNum++;
            }
            if (visitedNum == nextVisit.length) {
                return days;
            }
            if (visitTimes[nextPostion] % 2 == 1) {
                nextPostion = nextVisit[nextPostion];
            } else {
                nextPostion = (nextPostion + 1) % nextVisit.length;
            }
            days++;
        }
    }

    public static void main(String[] args) {
        int[] nextVisit = new int[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0
        };
        nextVisit = new int[]{
                0, 1, 2, 0
        };
        System.out.printf("" + System.currentTimeMillis());
        long rs = firstDayBeenInAllRooms(nextVisit);
        System.out.printf("" + System.currentTimeMillis());
    }
}
