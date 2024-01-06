package com.licslan.interview.algorithmskills.link;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 提示
 * 中等
 * 2.5K
 * 相关企业
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Lc19removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //判断空
        if (head == null || n <= 0) return null;

        //定义一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //定义快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;

        //让快指针先走N步
        for (int i = 0; i < n; i++) {
            //对fast 链表判空
            if (fast == null) return null;
            fast = fast.next;
        }

        //快慢指针一起走 一直到快指针的链表走到链表尾了
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //找到倒数的第N个节点了  此时slow指向的节点的下一个节点就是要删除的节点
        slow.next = slow.next.next;

        //返回删除后的节点的下一个节点即可
        return dummy.next;

    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        //先找到倒数第N+1个节点 再删倒数第N个节点
        ListNode kNode = findKNode(dummy, n + 1);


        //再删倒数第N个节点
        kNode.next = kNode.next.next;

        return dummy.next;

    }

    private ListNode findKNode(ListNode head, int k) {

        if (head == null) return null;
        ListNode p = head;
        //走k步
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        ListNode p2 = head;
        //同时走n-k步

        while (p != null) {
            p = p.next;
            p2 = p2.next;
        }

        return p2;

    }


}
