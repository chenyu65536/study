package com.rain.leetcode.tree;


import com.rain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1288 👎 0


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
public class Q98 {


    private boolean isValid = true;
    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }

    public void dfs(TreeNode node) {
        if (node == null || !isValid) {
            return;
        }
        dfs(node.left);
        if (pre != null && node.val <= pre) {
            isValid = false;
        }
        pre = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        /**
         * 			测试用例:[2,1,3]
         * 			测试结果:false
         * 			期望结果:true
         * 			stdout:
         */

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(227);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(911);

        node1.left = node2;
        node1.right = node3;
/*
        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;*/

        Q98 q = new Q98();
        boolean rs = q.isValidBST(node1);
        System.out.printf("");

    }
}
