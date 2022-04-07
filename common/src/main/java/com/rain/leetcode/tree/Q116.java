package com.rain.leetcode.tree;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
//next 指针连接，'#' 标志着每一层的结束。
//
//
//
//
// 示例 2:
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点的数量在 [0, 2¹² - 1] 范围内
// -1000 <= node.val <= 1000
//
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 722 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
public class Q116 {

    public Node connect(Node root) {
        connectChild(root);
        return root;
    }

    private void connectChild(Node parent) {
        if (parent == null || parent.left == null || parent.right == null) {
            return;
        }
        Node parentNext = parent.next;
        parent.left.next = parent.right;

        if (parentNext != null) {
            parent.right.next = parentNext.left;
        }
        connectChild(parent.left);
        connectChild(parent.right);
    }

    public static void main(String[] args) {

    /*    测试用例:[-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]
        测试结果:[-1,#,0,1,#,2,3,4,5,#,6,7,8,9,#]
        期望结果:[-1,#,0,1,#,2,3,4,5,#,6,7,8,9,10,11,12,13,#]
        */

        Node node = new Node(-1);

        Node node2 = new Node(0);
        Node node3 = new Node(1);


        Node node4 = new Node(2);
        Node node5 = new Node(3);
        Node node6 = new Node(4);
        Node node7 = new Node(5);


        Node node8 = new Node(6);
        Node node9 = new Node(7);
        Node node10 = new Node(8);
        Node node11 = new Node(9);

        Node node12 = new Node(10);
        Node node13 = new Node(11);
        Node node14 = new Node(12);
        Node node15 = new Node(13);


        node.left = node2;
        node.right = node3;

        node2.left = node4;
        node2.right = node5;


        node3.left = node6;
        node3.right = node7;


        Q116 q116 = new Q116();
        q116.connect(node);

        System.out.printf("11");
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
