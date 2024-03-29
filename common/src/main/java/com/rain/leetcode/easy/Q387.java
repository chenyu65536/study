package com.rain.leetcode.easy;

public class Q387 {

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q387 q387 = new Q387();
        System.out.println(q387.firstUniqChar("leetcode"));/*
        System.out.println(q387.firstUniqChar("loveleetcode"));
        System.out.println(q387.firstUniqChar("aabb"));*/
    }
}
