package com.licslan.interview.algorithmskills.link;

import com.licslan.interview.hot100.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author licslan
 *
 * LeetCode 专栏  ♥  NO160
 *
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 自定义评测：
 * <p>
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * <p>
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 */
public class IntersectionNode160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    //ab双指针 不停移动 每当一个指针移动为null时 指向另一个链表节点的头节点再从头开始遍历

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {


        if (headA == null || headB == null) {
            return null;
        }

        //定义2个指针
        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            // 遍历headA 如果pa移动到了（指向） null 就从headB开始遍历 否则就正常遍历pa
            pa = pa == null ? headB : pa.next;
            // 遍历headA 如果pb移动到了（指向） null 就从headA开始遍历 否则就正常遍历pb
            pb = pb == null ? headA : pb.next;
        }

        //否则计算相等了 相交了

        return pa;
    }


    //思路 1.先求出2个链表的长度 l1,l2 2.求出diff = |l1-l2|
    // 3.再移动到diff的节点 此时2者就一样长了  4.再一起遍历 有相同的值就是相交点了

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        //1.先求出2个链表的长度 l1,l2
        int l1 = 0, l2 = 0, diff = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null) {
            pa = pa.next;
            l1++;
        }
        while (pb != null) {
            pb = pb.next;
            l2++;
        }
        //2.求出diff = |l1-l2|  长度长的赋值给pa 需要遍历pa
        if (l1 > l2) {
            pa = headA;
            pb = headB;
            diff = l1 - l2;
        } else {
            pa = headB;
            pb = headA;
            diff = l2 - l1;
        }

        //3.再移动到diff的节点 此时2者就一样长了
        for (int i = 0; i < diff; i++) {
            pa = pa.next;
        }

        //4.2个链表长度一样了再一起遍历 有相同的值就是相交点了
        while (pa != null && pb != null) {
            //相交
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }

        return null;
    }


}
