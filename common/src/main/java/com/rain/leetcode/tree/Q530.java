package com.rain.leetcode.tree;
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点的数目范围是 [2, 10⁴]
// 0 <= Node.val <= 10⁵
//
//
//
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 284 👎 0


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
public class Q530 {

    private Integer pre = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }


    public static void main(String[] args) {

        /**
         *     4
         *    / \
         *   2   6
         *   / \
         *  1  3
         */
        //4,2,6,1,3
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = null;
        TreeNode node7 =null;

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        /**
         * 		   解答失败:
         * 			测试用例:[236,104,701,null,227,null,911]
         * 			测试结果:123
         * 			期望结果:9
         *
         * 	        236
         * 	   104       701
         * 	null 227   null 911
         */
        Q530 q530 = new Q530();
        int rs = q530.getMinimumDifference(node1);

        System.out.printf("" + rs);
    }
}
