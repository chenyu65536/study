package com.rain.leetcode.tree;

import com.rain.leetcode.bean.TreeNode;

//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 349 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Q404 {

    public static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(null, root, 0);
    }

    public static int sumOfLeftLeaves(TreeNode father, TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        //叶子节点判定
        if (father != null && node.left == null && node.right == null && father.left == node) {
            sum += node.val;
        } else {
            sum += sumOfLeftLeaves(node,node.left,0);
            sum += sumOfLeftLeaves(node,node.right,0);
        }
        return sum;
    }

    public static void main(String[] args) {

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        int rs = sumOfLeftLeaves(node1);

        System.out.printf("11");
    }
}
