package com.rain.algorithm;

import java.util.*;

/**
 * Created by chenyu on 2017/1/3.
 */
public class RandomNum {

    /**
     * 使用随机算法产生一个数，要求把1-100W之间这些数全部生成。
     * （考察高效率，解决产生冲突的问题）
     */
    private static void test1() {
        int value = 1000000;
        int partConunt = 1;
        //   HashMap<Integer,Set<Integer>> dataMap= new HashMap<>();
        Set[] sets = new Set[partConunt];
        for (int i = 0; i < partConunt; i++) {
            sets[i] = new HashSet<Integer>();
        }
        Random random = new Random();
        long a = System.currentTimeMillis();

        int resultCount = 0;
        while (resultCount < value) {
            int i = random.nextInt(value + 1);
            int index = (i - 1) / (value / partConunt);
            Set set = sets[index];
            int beforeCount = set.size();
            set.add(i);
            int endCount = set.size();
            if (beforeCount != endCount) {
                resultCount++;
            }
        }

        System.out.println("\r<br> 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
        //  System.out.println("完了，集合大小为" + result.size());
    }

    private static void test2() {
        int value = 1000000;
        Set<Integer> result = new HashSet<>();
        Random random = new Random();
        long a = System.currentTimeMillis();
        while (result.size() < value + 1) {
            int i = random.nextInt(value + 1);
            result.add(i);
        }
        System.out.println("\r<br> 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
        System.out.println("完了，集合大小为" + result.size());
    }


    public static void main(String[] args) {
        test1();
        test2();
        List<String> list = new ArrayList<>();
    }
}
