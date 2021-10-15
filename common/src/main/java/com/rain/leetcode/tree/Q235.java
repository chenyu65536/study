package com.rain.leetcode.tree;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//
//
// 示例 2:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 678 👎 0


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
 * TreeNode(int x) { val = x; }
 * }
 */

public class Q235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        find(root, p, pPath);
        find(root, q, qPath);

        int length = Math.min(pPath.size(), qPath.size());

        for (int i = 0; i < length; i++) {
            if (pPath.get(i).val != qPath.get(i).val) {
                return pPath.get(i - 1);
            }
        }
        return pPath.get(length - 1);
    }

    public void find(TreeNode node, TreeNode target, List<TreeNode> path) {
        path.add(node);
        if (node.val == target.val) {
            //path.add(node);
        } else if (node.val > target.val) {
            find(node.left, target, path);
        } else {
            find(node.right, target, path);
        }
    }

    public static void main(String[] args) {
        //[6,2,8,0,4,7,9,null,null,3,5]
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);

        TreeNode node8 = null;
        TreeNode node9 = null;

        TreeNode node10 = new TreeNode(3);
        TreeNode node11 = new TreeNode(5);


        node1.left = node2;
      /*  node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node10;
        node5.right = node11;*/
        Q235 q235 = new Q235();
        TreeNode rs = q235.lowestCommonAncestor(node1, node2, node1);
        System.out.printf("11");

    }
}
