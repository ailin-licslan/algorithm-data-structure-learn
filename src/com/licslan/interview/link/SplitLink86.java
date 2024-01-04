package com.licslan.interview.link;


import com.licslan.datastructure.linkedlist.ListNode;

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



    //双指针

    public ListNode partition(ListNode head, int x) {


        //<x
        ListNode dummy1 = new ListNode(-1);
        //>x
        ListNode dummy2 = new ListNode(-1);

        //p1 p2 负责生产大小链表
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;


        //将以前的链表一份为2  x 作为参照物
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;   // 注意：如果写成这样的话 p2.next = new ListNode(p.val) 就不用处理下面的断开链表指向关系 但是会消耗空间哈
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }



            //而不是 p=p.next 需要断开关系

            //断开链表中每个节点的指针  不过也是原始链表的原始向遍历方向移动了一位获得了新值  只是断开了原始链表指向关系  因为已经存在新链表里面了 循环里面会赋予新的指向关系 比如  p2.next = p;
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        //合并2个链表
        p1.next=dummy2.next;
        return dummy1.next;


    }
}
