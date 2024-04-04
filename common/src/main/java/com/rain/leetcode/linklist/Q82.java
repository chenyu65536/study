package com.rain.leetcode.linklist;
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
// Related Topics 链表 双指针 👍 951 👎 0


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
public class Q82 {

    /**
     * 测试用例:[1,2,3,3,4,4,5]
     * 测试结果:[1,2,3,4,5]
     * 期望结果:[1,2,5]
     * <p>
     * 1,2,2
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode newCurrent = null;

        ListNode preNode = null;
        ListNode currentNode = head;

        //查找头节点
        while (currentNode != null && newHead == null) {
            if ((preNode == null || currentNode.val != preNode.val) && (currentNode.next == null || currentNode.val != currentNode.next.val)) {
                newHead = currentNode;
                newCurrent = newHead;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        if (newHead == null) {
            return newHead;
        }

        //追加后续节点
        while (currentNode != null) {
            if (preNode.val != currentNode.val
                    && (currentNode.next == null || currentNode.val != currentNode.next.val)) {
                newCurrent.next = currentNode;
                newCurrent = currentNode;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        newCurrent.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        //1->2->3->4->5, 和 k = 2.
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node3_2 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node4_2 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node3_2;
        node3_2.next = node4;
        node4.next = node4_2;
        node4_2.next = node5;

        Q82 o22 = new Q82();
        ListNode result = o22.deleteDuplicates(node1);

        System.out.printf("111");
    }

}
