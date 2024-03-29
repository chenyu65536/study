package com.rain.leetcode.medium;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针 👍 1573 👎 0


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
public class Q19 {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = null;
        int step = 0;
        while (fast.next != null) {
            step++;
            if (step == n) {
                slow = head;
            } else if (step > n) {
                slow = slow.next;
            }
            fast = fast.next;

        }
        if (slow != null) {
            slow.next = slow.next.next;
            return head;
        } else {
            return head.next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int tailIdx = 0;
        ListNode current = head;
        ListNode pre = null;
        while (current.next != null) {
            current = current.next;

            tailIdx++;
            if (tailIdx == n) {
                pre = head;
            }
            if (tailIdx > n) {
                pre = pre.next;
            }
        }
        if (pre == null) {
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        Q19 q19 = new Q19();

        ListNode rs = q19.removeNthFromEnd2(node1, 3);

        System.out.printf("11");
    }
}
