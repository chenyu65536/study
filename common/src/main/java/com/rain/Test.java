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

    public static void readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                System.out.println(tempStr.replaceAll("\t",","));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        Thread thread = new Thread();
        thread.interrupt();

        ThreadLocal<Long> a = new ThreadLocal<>();
        a.set(10L);
        a.get();


        LockSupport.park();

    }


    public static void main(String[] args) {
        PriorityQueue<Integer>[] counts = new PriorityQueue[26];
 /*       Integer a = 15;
        Integer b = 15;
        System.out.printf(""+(a==b));
        Map<Integer, Integer> map1 = null;
        List<Integer> nums = new ArrayList<>();
        //Arrays.sort(nums);

        LinkedList<Integer[]> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();*/

        for (int i=0;i<0;i++){
            System.out.printf("111");
        }
    }
}
