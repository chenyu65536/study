package com.rain.leetcode.tree;
//给定一个二叉树
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
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
//
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。
//
//
//
// 提示：
//
//
// 树中的节点数小于 6000
// -100 <= node.val <= 100
//
//
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 530 👎 0


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
public class Q117 {

    public Node connect(Node root) {
        connectChild(root);
        return root;
    }

    public void connectChild(Node node) {
        if (node == null) {
            return;
        }
        if(node.right != null){
            node.right.next = findNext(node.next);
        }
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                node.left.next = findNext(node.next);
            }
        }
        connectChild(node.right);
        connectChild(node.left);
    }

    private Node findNext(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        }
        if (node.right != null) {
            return node.right;
        }
        return findNext(node.next);
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

    public static void main(String[] args) {
/**
 *
 测试用例:[0,2,4,1,null,3,-1,5,1,null,6,null,8]
 测试结果:[0,#,2,4,#,1,-1,#,5,1,8,#]
 期望结果:[0,#,2,4,#,1,3,-1,#,5,1,6,8,#]

 */

        Node node = new Node(2);

        Node node2 = new Node(1);
        Node node3 = new Node(3);
        node.left = node2;
        node.right = node3;

        Node node4 = new Node(0);
        Node node5 = new Node(7);
        Node node6 =  new Node(9);
        Node node7 = new Node(1);

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        Node node8 = new Node(2);
        Node node9 =  new Node(1);
        Node node10 = new Node(0);
        Node node11 = new Node(8);
        Node node12 = new Node(8);


        node4.left = node8;

        node5.left = node9;
        node5.right = node10;
        node7.left = node11;
        node7.right = node12;


        Q117 q117 = new Q117();
        q117.connect(node);

        System.out.printf("11");
    }
}
