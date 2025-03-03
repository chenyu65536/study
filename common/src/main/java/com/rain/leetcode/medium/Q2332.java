package com.rain.leetcode.medium;

import java.util.Arrays;

public class Q2332 {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int rs = 1;
        int b = 0, p = 0;
        int preTime = -1;
        while (b < buses.length) {
            int bTime = buses[b];
            int cnt = 0;
            // 往前找空隙进行排队=》  x,p1   x,p2   x,p3  y,btime
            while (p < passengers.length && passengers[p] <= bTime && cnt < capacity) {
                int passengerTime = passengers[p];
                if (passengerTime - preTime > 1) {
                    rs = passengerTime - 1;
                }
                preTime = passengerTime;
                p++;
                cnt++;
            }
            //如果没坐满，且最后一个乘客到达时间不是截止时间。那么则为截止时间
            if (cnt < capacity && preTime != bTime) {
                rs = bTime;
            }
            b++;
        }
        return rs;
    }

}
