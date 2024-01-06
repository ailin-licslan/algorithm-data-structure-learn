package com.licslan.interview.algorithmskills.link;

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


    //快慢指针

    public ListNode delDup3(ListNode head) {

        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null) {

            //一致没有找到想等的 就把fast那个节点赋值到slow上面去  再进行下一次循环

            if (fast.val != slow.val) {
                slow.next = fast;
                //slow ++
                slow = slow.next;
            }
            //fast ++
            fast = fast.next;
        }
        slow.next = null;
        return slow;
    }


    public ListNode delDup2(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        head.next = delDup2(head.next);

        return head.val == head.next.val ? head.next : head;
    }
}


