package com.licslan.interview.algorithmskills.link;

import com.licslan.datastructure.linkedlist.ListNode;

/**
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 */
public class GetKLink {



    //双指针同时走 一个先走 一个后走
    public ListNode kthToLast(ListNode head, int k) {


        ListNode p1 = head;

        for (int i = 0; i < k; i++) {
            //走k步
            p1 = p1.next;
        }

        ListNode p2 = head;

        //同时走 n-k 步 那就是  倒数的第 K个元素
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;

    }
}
