package com.rain.leetcode.tree;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树 👍 1075 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class Q102 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            trace(Collections.singletonList(root));
        }
        return rs;
    }

    public void trace(List<TreeNode> nodes) {
        List<Integer> row = new ArrayList<>();
        List<TreeNode> nextLevelNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            row.add(node.val);
            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }
        rs.add(row);
        if (nextLevelNodes.size() > 0) {
            trace(nextLevelNodes);
        }
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

        Q102 q = new Q102();
        List<List<Integer>> rs = q.levelOrder(node1);

        System.out.printf("11");
    }
}
