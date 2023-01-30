package com.licslan.interview.leetcode500;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author WEILIN
 * 合并2个有序的链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Merge2List21 {


    //1-->2-->5
    //0-->1-->3

    //0-->1-->1-->3-->5


    public ListNode merge2List(ListNode listNode1, ListNode listNode2) {

        //1.判断特殊情况
        if ((listNode1 == null)) {
            return listNode2;
        }

        if ((listNode2 == null)) {
            return listNode1;
        }

        //2.设计一个虚拟头节点   -1-->null
        ListNode head = new ListNode(-1);
        ListNode p = head;

        //双指针
        ListNode index1 = listNode1;
        ListNode index2 = listNode2;


        //2个链表都不为空
        while (index1 != null && index2 != null) {
            //如果链表 index 1 小一些  index1就加在 head后面
            if (index1.val <= index2.val) {
                p.next = new ListNode(index1.val);
                //指针指向下一个元素 再接着遍历
                index1 = index1.next;
            } else {
                p.next = new ListNode(index2.val);
                //指针指向下一个元素 再接着遍历
                index2 = index2.next;
            }
            //指针指向下一个元素 再接着遍历
            p = p.next;
        }


        //1个链表为空
        if (index1 != null) {
            p.next = index1;
        }

        //1个链表为空
        if (index2 != null) {
            p.next = index2;
        }


        //返回虚拟头节点的下一个节点的链表即可
        return head.next;
    }
}


