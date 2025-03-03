package com.rain.leetcode.medium;

import java.util.*;

public class Q2241 {

    int[] cnts;
    int[] denominations;
    public Q2241() {
        this.cnts = new int[5];
        this.denominations = new int[]{20,50,100,200,500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            cnts[i] += banknotesCount[i];
        }
    }

    public static void  generateKey(int num1, int num2, int num3) {

    }


    public static void main(String[] args) {
        //["ATM","deposit","withdraw","deposit","withdraw","withdraw"]
        //[[],[[0,0,1,2,1]],[600],[[0,1,0,1,1]],[600],[550]]
        Q2241 q2241 = new Q2241();
//        q2241.deposit(new int[]{0,0,1,2,1});
//        q2241.withdraw(600);
//        q2241.deposit(new int[]{0,1,0,1,1});
//        q2241.withdraw(600);
//        q2241.withdraw(550);
        String word1;

       // q2241.deposit(new int[]{0,10,0,3,0});
       // q2241.generateKey(1140,1851,2057);

        int rs = 2^1^8;
        System.out.printf("");
    }

}
