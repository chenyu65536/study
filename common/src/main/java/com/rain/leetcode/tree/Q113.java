package com.rain.leetcode.tree;
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3], targetSum = 5
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1,2], targetSum = 0
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点总数在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
//
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 610 👎 0


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
public class Q113 {

    List<List<Integer>> rs = new ArrayList<>();
    private int targetSum;
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0);
        return rs;
    }


    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum = node.val + sum;
        path.add(node.val);

        if (node.left == null && node.right == null && sum == targetSum) rs.add(new ArrayList<>(path));

        dfs(node.left, sum);
        dfs(node.right, sum);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        /**
         * 	[5,4,8,11,null,13,4,7,2,null,null,5,1]
         *            5
         *
         *       4              8
         *
         *   11   null      13       4
         * 7   2                   5   1
         */
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = null;


        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = null;
        TreeNode node11 = null;
        TreeNode node12 = new TreeNode(5);
        TreeNode node13 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;


        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node7.left = node12;
        node7.right = node13;



        Q113 q = new Q113();
        List<List<Integer>> rs = q.pathSum(node1, 22);
        System.out.printf("" + rs);


        /**
         * 	        info
         * 			解答失败:
         * 			测试用例:[5,4,8,11,null,13,4,7,2,null,null,5,1]
         * 			22
         * 			测试结果:[[5,4,11,2]]
         * 			期望结果:[[5,4,11,2],[5,8,4,5]]
         * 			stdout:
         *
         *
         */
    }
}
