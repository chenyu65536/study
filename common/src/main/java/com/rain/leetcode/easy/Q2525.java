package com.rain.leetcode.easy;

public class Q2525 {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        if (length >= 10000 || width >= 10000 || height >= 10000 || (long) length * width * height >= 1000000000) {
            isBulky = true;
        }
        boolean isHeavy = false;
        if (mass >= 100) {
            isHeavy = true;
        }
        if (isHeavy && isBulky) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
        //Bulky Heavy
    }
}
