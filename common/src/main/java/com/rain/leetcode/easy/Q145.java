package com.rain.leetcode.easy;
//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 678 👎 0


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
public class Q145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        if (root.left != null) {
           rs.addAll(postorderTraversal(root.left)) ;
        }
        if (root.right != null) {
            rs.addAll(postorderTraversal(root.right)) ;
        }
        rs.add(root.val);
        return rs;
    }

}
