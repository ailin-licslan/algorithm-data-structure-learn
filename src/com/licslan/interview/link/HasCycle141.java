package com.licslan.interview.link;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author WEILIN
 * LeetCode 专栏  ♥  NO141
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * <p>
 * 可以使用快慢指针法， 分别定义 fast 和 slow指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
 * <p>
 * 为什么fast 走两个节点，slow走一个节点，有环的话，一定会在环内相遇呢，而不是永远的错开呢？
 * <p>
 * 首先第一点： fast指针一定先进入环中，如果fast 指针和slow指针相遇的话，一定是在环中相遇，这是毋庸置疑的。
 * <p>
 * 那么来看一下，为什么fast指针和slow指针一定会相遇呢？
 * <p>
 * 可以画一个环，然后让 fast指针在任意一个节点开始追赶slow指针
 * <p>
 * fast和slow各自再走一步， fast和slow就相遇了
 * <p>
 * 这是因为fast是走两步，slow是走一步，其实相对于slow来说，fast是一个节点一个节点的靠近slow的，所以fast一定可以和slow重合
 */
public class HasCycle141 {


    //福洛伊德解法

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //FAST指针 先走2步 比慢指针
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        //不包含环
        return false;
    }

}



