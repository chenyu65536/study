package com.rain.leetcode.medium;
//给你一个有根节点
// root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
//
// 回想一下：
//
//
// 叶节点 是二叉树中没有子节点的节点
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
//
//
// 示例 3：
//
//
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
//
//
//
// 提示：
//
//
// 树中的节点数将在
// [1, 1000] 的范围内。
// 0 <= Node.val <= 1000
// 每个节点的值都是 独一无二 的。
//
//
//
//
// 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-
//the-deepest-nodes/
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 187 👎 0


import com.rain.leetcode.bean.TreeNode;

import java.util.*;

public class Q1123 {

    int maxDepth = 1;
    Set<NodePair>[] map = new HashSet[1000];

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        travelTree(new NodePair(null, root), 1);
        Set<NodePair> nodePairs = map[maxDepth];
        if (nodePairs == null || nodePairs.isEmpty()) {
            return root;
        }
        if (nodePairs.size() == 1) {
            return nodePairs.stream().findAny().get().current;
        }
        return findPublicNode(nodePairs);
    }

    private TreeNode findPublicNode(Set<NodePair> nodePairs) {
        Set<NodePair> parents = new HashSet<>();
        for (NodePair pair : nodePairs) {
            parents.add(pair.parent);
        }

        if (parents.size() > 1) {
            return findPublicNode(parents);
        } else {
            return parents.stream().findAny().get().current;
        }
    }

    private void travelTree(NodePair parent, int depth) {
        Set<NodePair> pairs = null;
        depth++;
        if (map[depth] != null) {
            pairs = map[depth];
        } else {
            pairs = new HashSet<>();
        }
        if (parent.current.right != null) {
            NodePair newPair = new NodePair(parent, parent.current.right);
            pairs.add(newPair);
            travelTree(newPair, depth);
        }
        if (parent.current.left != null) {
            NodePair newPair = new NodePair(parent, parent.current.left);
            pairs.add(newPair);
            travelTree(newPair, depth);
        }
        if (!pairs.isEmpty()) {
            map[depth] = pairs;
            maxDepth = Math.max(maxDepth, depth);
        }
    }

    class NodePair {
        public NodePair parent;
        public TreeNode current;

        public NodePair(NodePair parent, TreeNode current) {
            this.parent = parent;
            this.current = current;
        }
    }


    public static void main(String[] args) {
        Integer[] temp = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode treeNode = TreeNode.createTree(temp, 0);
        Q1123 q1123 = new Q1123();
        TreeNode rs = q1123.lcaDeepestLeaves(treeNode);
        System.out.printf("11");
    }
}
