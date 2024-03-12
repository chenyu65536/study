package com.rain.leetcode.easy;

import java.util.Stack;

public class Q232 {
    Stack<Integer> in,out;
    public Q232() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.empty()) {
            resetOut();
        }
        return out.pop();
    }

    public int peek() {
        if (out.empty()){
            resetOut();
        }
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty() && in.empty();
    }

    private void resetOut(){
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }

}
