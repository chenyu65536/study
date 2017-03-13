package com.rain.algorithm.tree;

/**
 * Created by chenyu on 2017/3/13.
 * 树节点
 */
public class TreeNode {
    public TreeNode father;
    public TreeNode left;
    public TreeNode right;
    public String value;


    public TreeNode(String value) {
        this.value = value;
    }
}
