package com.rain.leetcode.easy.e1;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
// 👍 655 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Q108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = nums[(startIndex + endIndex) / 2];

        node.left = sortedArrayToBST(nums, startIndex, (startIndex + endIndex) / 2 - 1);
        node.right = sortedArrayToBST(nums, (startIndex + endIndex) / 2 + 1, endIndex);
        return node;
    }

    /**
     * 解答失败: 测试用例:[-10,-3,0,5,9] 测试结果:[0,-10,5,-3,null,9] 期望结果:[0,-3,9,-10,null,5] stdout:
     * @param args
     */
    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}
