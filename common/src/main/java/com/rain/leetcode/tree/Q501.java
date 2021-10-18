package com.rain.leetcode.tree;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 359 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class Q501 {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        traceTree(root);
        List<Integer> data = map.keySet().stream().filter(key -> map.get(key) == maxCount)
                .collect(Collectors.toList());
        int[] rs = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            rs[i] = data.get(i);
        }
        return rs;
    }

    public void traceTree(TreeNode node) {
        if (node == null) {
            return;
        }
        int count = (map.containsKey(node.val) ? map.get(node.val) : 0) + 1;
        map.put(node.val, count);
        maxCount = Math.max(count, maxCount);
        if (node.left != null) {
            traceTree(node.left);
        }

        if (node.right != null) {
            traceTree(node.right);
        }
    }


    public static void main(String[] args) {

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);

        node1.right = node2;

        node1.left = node3;

        System.out.printf("11");

        Q501 q501 = new Q501();

        int[] rs = q501.findMode(node1);

        System.out.printf("11");
    }
}
