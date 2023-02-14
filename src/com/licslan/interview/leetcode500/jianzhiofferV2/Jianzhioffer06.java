package com.licslan.interview.leetcode500.jianzhiofferV2;

import com.licslan.interview.hot100.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licslan
 */
public class Jianzhioffer06 {

    public int[] reversePrint(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        List<Integer> a = new ArrayList<>();
        while (pre != null) {
            a.add(pre.val);
            pre = pre.next;
        }
        return a.stream().mapToInt(Integer::intValue).toArray();

    }


    public int[] reversePrint2(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        int length = 0;

        //反转链表

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            length++;
        }


        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = pre.val;
            pre = pre.next;
        }
        return a;
    }
}
