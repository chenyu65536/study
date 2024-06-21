package com.rain.leetcode.medium;

public class Q1997 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int len = nextVisit.length;
        int visitCount = 0;
        int next = 0;
        boolean[][] isVisited = new boolean[len][2];
        while (!isVisited[next][visitCount % 2]) {
            visitCount++;
            isVisited[next][visitCount % 2] = true;
            if (visitCount % 2 == 1) {
                next = nextVisit[next];
            } else {
                next = (next + 1) % len;
            }
        }
        return visitCount;
    }

    public static void main(String[] args) {
        Q1997 q1997 = new Q1997();
        int rs = q1997.firstDayBeenInAllRooms(new int[]{0, 0, 2});
        //idx :  0->1->0->0->2
        System.out.printf("" + rs);
    }

}
