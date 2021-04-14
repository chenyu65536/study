package com.rain.leetcode.bean;


public class TriesNode {

    public char val;
    public TriesNode[] child = new TriesNode[26];
    public boolean isEnd = false;

    public TriesNode() {
    }

    public TriesNode(char val) {
        this.val = val;
    }

}
