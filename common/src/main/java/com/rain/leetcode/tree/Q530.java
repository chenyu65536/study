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

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        dfs(root, rs);

        int min = rs.get(1) - rs.get(0);
        for (int i = 2; i < rs.size(); i++) {
            min = Math.min(rs.get(i) - rs.get(i - 1), min);
        }
        return min;
    }

    public static void dfs(TreeNode node, List<Integer> rs) {
        if (node == null) {
            return;
        }
        dfs(node.left, rs);
        rs.add(node.val);
        dfs(node.right, rs);
    }


    public static void main(String[] args) {

        /**
         *     4
         *    / \
         *   2   6
         *   / \
         *  1  3
         */
        TreeNode node1 = new TreeNode(236);
        TreeNode node2 = new TreeNode(104);
        TreeNode node3 = new TreeNode(701);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(227);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(911);

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
        int rs = getMinimumDifference(node1);

        System.out.printf("" + rs);
    }
}
