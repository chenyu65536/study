package com.rain.leetcode.medium;

import com.rain.leetcode.bean.TreeNode;

public class Q1038 {
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(null, root);
        return root;
    }

    public TreeNode bstToGst(TreeNode parent, TreeNode node) {
        if (node == null) {
            return new TreeNode(0, null, null);
        }
        bstToGst(null, node.left);
        node.val = node.left.val + node.val + (parent == null ? 0 : parent.val);
        bstToGst(parent, node.right);
        return node;
    }
}
