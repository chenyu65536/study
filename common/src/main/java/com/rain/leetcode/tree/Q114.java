package com.rain.leetcode.tree;
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 970 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Q114 {

    private List<Integer> rs = new ArrayList<>();
    private TreeNode pre = null;

    public void flatten(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        rs.add(node.val);
        if (pre != null) {
            pre.left = null;
            pre.right = node;
            pre = node;
        } else {
            pre = node;
            pre.left = null;
        }

        flatten(left);
        flatten(right);
    }

    public static void main(String[] args) {

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         * 3 9 20 15 7
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

        Q114 q  = new Q114();
        q.flatten(node1);

        /**
         * 		    测试用例:[1,2,3,4,null,null,5]
         * 			测试结果:[[1],[3,2],[5,4]]
         * 			期望结果:[[1],[3,2],[4,5]]
         */
        System.out.printf("11");
    }


}
