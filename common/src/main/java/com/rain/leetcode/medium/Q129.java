package com.rain.leetcode.medium;

import com.rain.leetcode.bean.TreeNode;

public class Q129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root);
    }

    int val = 0;
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        val = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            return val;
        }
        int ans = 0;
        if (node.left != null) {
            ans += dfs(node.left);
            val /= 10;
        }

        if (node.right != null) {
            ans += dfs(node.right);
            val /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q129 q129 = new Q129();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int res = q129.sumNumbers(root);
        System.out.printf("" + res);
    }
}
