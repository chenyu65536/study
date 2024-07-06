package com.rain;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/5/15 4:50 下午
 */
public class Test {

    public static int maximumLength(int[] nums) {
        //全偶数 or 奇数 %=0

        int oddStartCount = 0;
        int evenStartCount = 0;
        int oddEvenStartCount = 1;

        boolean oddEvenStartStartFlag = (nums[0]%2==0);


        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                evenStartCount++;
            }else{
                oddStartCount++;
            }
            if(i>0 && oddEvenStartStartFlag!=(nums[i]%2==0)){
                oddEvenStartCount++;
                oddEvenStartStartFlag = !oddEvenStartStartFlag;
            }
        }

        int rs1 = Math.max(evenStartCount,oddStartCount);
        return Math.max(rs1,oddEvenStartCount);
        //奇数+偶数
    }


    public static void main(String[] args) {
        maximumLength(new int[]{3,7,6});
        Map<String,Integer> memo = new HashMap();
        BitSet set = new BitSet();
    }
}
