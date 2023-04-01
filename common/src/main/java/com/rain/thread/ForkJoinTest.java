package com.rain.thread;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    //产生一个随机数组
    private static int[] array = new int[100];
    //阈值
    private final static int POINT = array.length / 10;


    //有返回值的任务
    private static class SumTask extends RecursiveTask<Integer> {

        //要累加的源数组
        private int[] src;
        //开始角标
        private int startIndex;
        //结束角标
        private int endIndex;

        public SumTask(int[] src, int startIndex, int endIndex) {
            this.src = src;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        //实现具体的累加逻辑和任务分割逻辑
        @Override
        protected Integer compute() {
            //不满足阈值的时候，这里面的逻辑也是当满足阈值的时候，递归执行的逻辑
            if (endIndex - startIndex < POINT) {
                int count = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    count += src[i];
//                    SleepTools.ms(1);
                }
                return count;

                //满足阈值的时候，需要分割任务，然后交给forkjoinpool去执行任务
            } else {

                //当需要分割的时候，采用折中法进行分割
                //startIndex.......mid.......endIndex
                int mid = (startIndex + endIndex) / 2;

                //左任务
                SumTask leftTask = new SumTask(src, startIndex, mid);
                //右任务
                SumTask rigthTask = new SumTask(src, mid + 1, endIndex);

                //交给forkjoinpool去执行任务
                invokeAll(leftTask, rigthTask);

                //将执行结果返回
                return leftTask.join() + rigthTask.join();
            }
        }
    }
}