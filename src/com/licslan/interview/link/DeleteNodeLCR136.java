package com.licslan.interview.link;

import com.licslan.datastructure.linkedlist.ListNode;

/**
 * LCR 136. 删除链表的节点
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class DeleteNodeLCR136 {

    public ListNode deleteNode(ListNode head, int val) {

        // 如果头节点就是要删除的节点
        if (head != null && head.val == val) {
            return head.next;
        }

        // 遍历链表找到要删除的节点的前一个节点 如果等于了 就往下走了 当前节点的下个节点是等于val的 那么就会跳出循环了 往下走了
        ListNode current = head;
        while (current != null && current.next != null && current.next.val != val) {
            current = current.next;
        }

        // 如果找到了要删除的节点的前一个节点，将其连接到下一个节点
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }

        return head;

    }
}
