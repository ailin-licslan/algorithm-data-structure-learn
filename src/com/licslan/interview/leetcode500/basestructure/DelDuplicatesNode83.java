package com.licslan.interview.leetcode500.basestructure;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author licslan
 */
public class DelDuplicatesNode83 {

    public ListNode delDup(ListNode head) {


        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur.next != null) {
            //连续相等值
            if (cur.val == cur.next.val) {
                //当前的一个节点的指向  ==》 直接跳过当前节点的下一个节点的指向 而是指向当前节点的下下个节点
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public ListNode delDup2(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        head.next = delDup2(head.next);

        return head.val == head.next.val ? head.next : head;
    }
}


