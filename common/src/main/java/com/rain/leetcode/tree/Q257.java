package com.rain.leetcode.tree;
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 592 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

import java.util.ArrayList;
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
public class Q257 {

    List<String> rs = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return rs;
        }
        recursion(root, null);
        return rs;
    }

    public void recursion(TreeNode node, String path) {
        if (path == null) {
            path = "" + node.val;
        } else {
            path = path + "->" + node.val;
        }

        //叶子节点添加到结果
        if (node.left == null && node.right == null) {
            rs.add(path);
            return;
        }

        //非叶子节点继续遍历
        if (node.left != null) {
            recursion(node.left, path);
        }
        if (node.right != null) {
            recursion(node.right, path);
        }
    }

    public static void main(String[] args) {
        /**
         *      4
         *    /   \
         *   2     7
         *  / \   / \
         * 1   3 6   9
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

      /*  node4.left = node2;
        node4.right = node7;

        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node9;*/

        Q257 q = new Q257();
        List<String> rs = q.binaryTreePaths(node4);
        System.out.printf("11");
    }
}
