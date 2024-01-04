package com.licslan.interview.hot100;

/**
 * 86. 分隔链表
 * 中等
 * 803
 * 相关企业
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class SplitLink86 {

    public ListNode partition(ListNode head, int x) {


        //<x
        ListNode dummy1 = new ListNode(-1);
        //>x
        ListNode dummy2 = new ListNode(-1);

        //p1 p2 负责生产大小链表
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            //断开链表中每个节点的指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        //连接2个链表
        p1.next=p2.next;
        return p1.next;


    }
}
