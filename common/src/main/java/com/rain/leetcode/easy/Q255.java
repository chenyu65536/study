package com.rain.leetcode.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q255 {


    Queue<Integer> q1;
    Queue<Integer> q2;


    public Q255() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        //swap
        Queue<Integer> temp  = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
