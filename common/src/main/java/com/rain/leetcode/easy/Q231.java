package com.rain.leetcode.easy;

public class Q231 {

    public boolean isPowerOfTwo(int n) {
        long muti = 1;
        while (muti < n) {
            muti = muti * 2;
        }
        return muti==n;
    }
}
