package com.rain.leetcode.easy;

public class Q2678 {

    public int countSeniors(String[] details) {
        int sum = 0;
        for (String detail : details) {
            char age1 = detail.charAt(11);
            char age2 = detail.charAt(12);
            sum += (age1 > '6' || (age1 == '6' && age2 > '0')) ?1 :0;
        }
        return sum;
    }
}
