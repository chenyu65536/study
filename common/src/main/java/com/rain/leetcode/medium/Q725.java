package com.rain.leetcode.medium;
//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
//
// 返回一个由上述 k 部分组成的数组。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//解释：
//输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 1000]
// 0 <= Node.val <= 1000
// 1 <= k <= 50
//
// Related Topics 链表 👍 192 👎 0


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
public class Q725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total = 0;
        ListNode countCurrent = head;
        if (head != null) {
            while (countCurrent != null) {
                total++;
                countCurrent = countCurrent.next;
            }
        }
        int baseNum = total / k;
        int additionalNum = total - total / k * k;

        ListNode[] rs = new ListNode[k];
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ListNode subHead = current;
            int subNum = 1;
            while (subNum < baseNum) {
                current = current.next;
                subNum++;
            }
            if (additionalNum > 0 && baseNum > 0) {
                current = current.next;
                additionalNum--;
            }

            if (current != null) {
                ListNode node = current.next;
                current.next = null;
                current = node;
                rs[i] = subHead;
            }
        }
        return rs;
    }

    public static void main(String[] args) {

        //输入：head = [1,2,3], k = 5
        //输出：[[1],[2],[3],[],[]]
      /*  ListNode node10 = new ListNode(10);
        ListNode node9 = new ListNode(9, node10);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);*/
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);


        Q725 q725 = new Q725();
        ListNode[] nodes = q725.splitListToParts(head, 5);
        System.out.printf("11");
    }
}
