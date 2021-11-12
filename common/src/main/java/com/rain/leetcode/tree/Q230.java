package com.rain.leetcode.tree;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,1,4,null,2], k = 1
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
//
//
//
//
//
//
// 提示：
//
//
// 树中的节点数为 n 。
// 1 <= k <= n <= 10⁴
// 0 <= Node.val <= 10⁴
//
//
//
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 521 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

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
public class Q230 {

    private int rs;
    private int index;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return rs;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        dfs(node.left, k);
        index++;
        if (index == k) {
            rs = node.val;
        } else if (k > index) {
            dfs(node.right, k);
        }
    }

    public static void main(String[] args) {
        /**
         *     1
         *    /   \
         *   null  2
         *
         *
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = null;
        TreeNode node3 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;

        Q230 q = new Q230();
        int rs = q.kthSmallest(node1, 2);
        System.out.printf("" + rs);
    }
}
