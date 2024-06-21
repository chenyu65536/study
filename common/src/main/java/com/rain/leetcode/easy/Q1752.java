package com.rain.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1752 {

    public static boolean check(int[] nums) {
        int lowIndex = -1;
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] <= nums[i + 1]) {
                lowIndex = i;
                break;
            }
        }
        // 单调递增
        if (lowIndex == -1) {
            if ((nums[0] <= nums[1] || nums[0] >= nums[len - 1])) {
                return true;
            }
            return false;
        }
        int offset = 0;
        while (offset < len-1) {
            if (nums[(lowIndex + offset) % len] > nums[(lowIndex + offset + 1) % len]) {
                return false;
            }
            offset++;
        }
        return true;
    }

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        s = "X"+s+"X";
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='?'){
                for(int j='a';j<='z';j++){
                    if((char)j!=sb.charAt(sb.length()-1) && (char)j!=s.charAt(i+1)){
                        sb.append((char)j);
                        break;
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {

    }

}
