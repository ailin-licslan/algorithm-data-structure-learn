package com.licslan.interview.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WEILIN
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
 */
public class GetIntersectionNode160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        //只要不相等  一直遍历下去  2个链表
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        //如果相等你们就会返回
        return pA;
    }


    /**
     * 思路和算法
     *
     * 判断两个链表是否相交，可以使用哈希集合存储链表节点。
     *
     * 首先遍历链表 headA\textit{headA}headA，并将链表 headA\textit{headA}headA 中的每个节点加入哈希集合中。然后遍历链表 headB\textit{headB}headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
     *
     * 如果当前节点不在哈希集合中，则继续遍历下一个节点；
     *
     * 如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分，因此在链表 headB\textit{headB}headB 中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
     *
     * 如果链表 headB\textit{headB}headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回 null\text{null}null。
     * */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
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


}
