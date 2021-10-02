package com.rain.leetcode.medium;

import com.rain.leetcode.bean.ListNode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表 👍 1063 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q24 {

    public static ListNode swapPairs(ListNode head) {
        if ((head == null || head.next == null)) {
            return head;
        }
        ListNode current = head;
        ListNode newHead = head.next;

        while (current != null && current.next != null) {
            ListNode node1 = current;
            ListNode node2 = current.next;

            ListNode node3 = node2.next;
            ListNode node4 = node3 == null ? null : node3.next;

            node2.next = node1;
            node1.next = node4 == null ? node3 : node4;

            current = node3;

        }
        return newHead;
    }

    public static void main(String[] args) {



        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode rs = swapPairs(node1);
        System.out.printf("2");
    }
}
