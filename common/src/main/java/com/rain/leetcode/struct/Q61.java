package com.rain.leetcode.struct;
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
// Related Topics 链表 双指针 👍 747 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.ListNode;
import com.rain.leetcode.easy.O22_100;

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
public class Q61 {


    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        if (size == 0 || (k = k % size) == 0) {
            return head;
        }

        ListNode tail = head;
        int index = 1;

        ListNode newHead = null;
        ListNode newTail = head;

        while (tail.next != null) {
            if (index == size - k) {
                newHead = tail.next;
                newTail = tail;
            }
            index++;
            tail = tail.next;
        }

        newTail.next = null;
        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        //1->2->3->4->5, 和 k = 2.
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Q61 q61 = new Q61();
        ListNode result = q61.rotateRight(node1, 2);

        System.out.printf("111");
    }
}
