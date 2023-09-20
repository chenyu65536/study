package com.rain.leetcode.bean;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            treeNode = new TreeNode(value);
            treeNode.left = createTree(array, 2 * index + 1);
            treeNode.right = createTree(array, 2 * index + 2);
            return treeNode;
        }
        return treeNode;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}