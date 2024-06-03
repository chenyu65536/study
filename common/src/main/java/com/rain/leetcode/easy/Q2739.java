package com.rain.leetcode.easy;

public class Q2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int rs = 0;
        int times = mainTank / 5;
        while (times > 0 && additionalTank > 0) {
            //跑路times后，剩下的油
            mainTank = mainTank % 5 + Math.min(additionalTank, times);
            //外挂油箱剩余的油
            additionalTank = Math.max(additionalTank - times, 0);
            rs += times * 10;
            times = mainTank / 5;
        }
        rs += mainTank * 10;
        return Math.min(rs, (mainTank + additionalTank) * 10);
    }


    public static void main(String[] args) {
        Q2739 q2739 = new Q2739();
        int rs = q2739.distanceTraveled(5, 10);
        System.out.printf("" + rs);
    }
}
