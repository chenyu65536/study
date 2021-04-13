package com.rain.leetcode.easy;

import com.rain.leetcode.bean.TreeNode;
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同
//
//
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
// 树中节点数目在范围 [2, 100] 内
// 0 <= Node.val <= 105
//
//
//
// Related Topics 树 深度优先搜索 递归
// 👍 131 👎 0

public class Q783 {

    public int minDiffInBST(TreeNode root) {
        int min = minDiff(root);
        if (root.left != null) {
            min = Math.min(min, minDiffInBST(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDiffInBST(root.right));
        }
        return min;
    }

    public int minDiff(TreeNode node) {
        //右边最小值
        if (node.left != null && node.right != null) {
            return Math.min(node.val - findMax(node.left), findMin(node.right) - node.val);
        } else if (node.left != null) {
            return node.val - findMax(node.left);
        } else if (node.right != null)
            return findMin(node.right) - node.val;

        return 106;
    }


    public int findMax(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return findMax(node.right);
    }

    public int findMin(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return findMin(node.left);
    }

    public static void main(String[] args) {
        //4,2,6,1,3
        Q783 q783 = new Q783();
       /*  TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
*/
        //90,69,null,49,89,null,52
        TreeNode root = new TreeNode(90);
        TreeNode node1 = new TreeNode(69);

        TreeNode node2 = new TreeNode(49);
        TreeNode node3 = new TreeNode(89);

        TreeNode node4 = new TreeNode(52);

        root.left = node1;

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        //27,null,34,null,58,50,null,44

     /*   TreeNode root = new TreeNode(27);

        TreeNode node1 = new TreeNode(34);
        TreeNode node2 = new TreeNode(58);
        TreeNode node3 = new TreeNode(50);
        TreeNode node4 = new TreeNode(44);

        root.right = node1;

        node1.right = node2;
        node2.left = node3;
        node3.left = node4;*/

        int min = q783.minDiffInBST(root);
        System.out.printf("" + min);


    }
}
