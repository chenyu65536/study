package com.rain.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumProcessor extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public SumProcessor(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start + 1 <= 50) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            SumProcessor processor1 = new SumProcessor(start, (start+end)/2);
            SumProcessor processor2 = new SumProcessor((start+end)/2+1, end);
            processor1.fork();
            processor2.fork();

            return processor1.join() + processor2.join();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture =  pool.submit(new SumProcessor(0,100));
        try {
            Integer result = taskFuture.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
    }

}