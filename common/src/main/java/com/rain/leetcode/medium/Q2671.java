package com.rain.leetcode.medium;

import java.util.HashMap;

public class Q2671 {
    HashMap<Integer, Integer> numsFreq;
    HashMap<Integer, Integer> freqNum;

    public Q2671() {
        numsFreq = new HashMap<>();
        freqNum = new HashMap<>();
    }

    public void add(int number) {
        int freq = numsFreq.getOrDefault(number, 0);
        numsFreq.put(number, freq + 1);

        freqNum.put(freq + 1, freqNum.getOrDefault(freq + 1, 0) + 1);

        if (freqNum.getOrDefault(freq, 0) > 1) {
            freqNum.put(freq, freqNum.get(freq) - 1);
        } else {
            freqNum.remove(freq);
        }
    }

    public void deleteOne(int number) {
        if (!numsFreq.containsKey(number)) {
            return;
        }
        int freq = numsFreq.get(number);
        if (freq > 1) {
            numsFreq.put(number, freq - 1);
        } else {
            numsFreq.remove(number);
        }

        int count = freqNum.get(freq);
        if (count > 1) {
            freqNum.put(freq, count - 1);
        } else {
            freqNum.remove(freq);
        }
        if (freq - 1 > 0) {
            freqNum.put(freq - 1, freqNum.getOrDefault(freq - 1, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqNum.containsKey(frequency);
    }

    public static void main(String[] args) {
        Q2671 q2671 = new Q2671();
        boolean rs = false;
        rs = q2671.hasFrequency(1);//false
        q2671.add(3);//null        3
        rs = q2671.hasFrequency(1);//true
        rs = q2671.hasFrequency(1);//true
        q2671.add(6);//null  3,6
        q2671.add(2);//null  3,6,2
        q2671.add(6);//null  3,6,2,6
        q2671.deleteOne(6);//null 3,6,2
        q2671.deleteOne(6);//null 3,2
        rs = q2671.hasFrequency(2);//false
        q2671.add(2);//null          3,2,2
        rs = q2671.hasFrequency(2);//true
        rs = q2671.hasFrequency(1);//true   false?
        System.out.printf("11");


    }
    //3,2,2
}
