package com.rain.leetcode.bean;

public class ListDNode {
    public int val;
    public ListDNode next;
    public ListDNode pre;
    public ListDNode() {
    }

    public ListDNode(int val) {
        this.val = val;
    }

    public ListDNode(int val, ListDNode next, ListDNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
