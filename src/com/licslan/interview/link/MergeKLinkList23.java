package com.licslan.interview.link;

import com.licslan.datastructure.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkList23 {


    public ListNode mergeKLists(ListNode[] lists) {


        if (lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;


        //优先级队列  最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));


        //将K个链表头节点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                //二叉堆 每次add poll 时间复杂度  O(logK)
                queue.add(head);
            }
        }


        //O(N * logK)
        while (!queue.isEmpty()) {
            //获取最小节点放到链表中
            ListNode data = queue.poll();
            p.next = data;
            if (data.next != null) {
                queue.add(data.next);
            }
            //p指针不断遍历前移动
            p = p.next;
        }


        return dummy.next;


    }
}
