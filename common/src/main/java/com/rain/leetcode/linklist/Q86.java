package com.rain.leetcode.linklist;
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [2,1], x = 2
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics 链表 双指针 👍 594 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.ListNode;

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
public class Q86 {

    public ListNode partition(ListNode head, int x) {
        ListNode next = head;
        ListNode smallHead = null;
        ListNode smallNext = null;
        //输入：head = [1,4,3,2,5,2], x = 3
        //输出：[1,2,2,4,3,5]
        ListNode bigHead = null;
        ListNode bigPre = null;
        while (next != null) {
            if (next.val < x) {
                if (smallHead == null) {
                    smallHead = next;
                    smallNext = smallHead;
                } else {
                    smallNext.next = next;
                    smallNext = next;
                }
                next = next.next;
                while (next != null && next.val < x) {
                    smallNext = next;
                    next = next.next;
                }
            } else {
                if (bigPre == null) {
                    bigHead = next;
                } else {
                    bigPre.next = next;
                }
                bigPre = next;
                next = next.next;
            }
        }
        if (smallHead == null || bigHead == null) {
            return head;
        }
        smallNext.next = bigHead;
        bigPre.next = null;
        return smallHead;
    }

    public static void main(String[] args) {
        //1,4,3,2,5,2
        //1,2,2,4,3,5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Q86 q86 = new Q86();
        ListNode rs = q86.partition(node1, 2);
        System.out.printf("xxx");
    }

}
