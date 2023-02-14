package com.licslan.interview.leetcode500.jianzhiofferV2;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author licslan
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 简单
 * 424
 * 相关企业
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class JianZhiOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {


        if (head == null || k == 0) {
            return null;
        }

        //思路 链表长度 - k + 1 就是要找的目标位置
        int len = 0, diff = 0;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            len++;
        }

        //需要移动的大小
        diff = len - k;
        for (int i = 0; i < diff; i++) {
            cur = cur.next;
        }

        return cur;


    }
}
