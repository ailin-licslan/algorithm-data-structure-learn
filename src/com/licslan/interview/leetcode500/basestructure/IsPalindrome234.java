package com.licslan.interview.leetcode500.basestructure;

import com.licslan.interview.hot100.utils.ListNode;

import java.util.Stack;

/**
 * @author licslan
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 */
public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;

        //装一下
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        //再一个个取出来对比 都相等就是的了
        while (cur != null) {
            if (stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }

        //说明前面的都满足
        return true;
    }

    //快慢指针移动

    public boolean isPalindrome2(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            //fast 指针一次移动2步 一直移到 fast==null (偶数个节点) || fast.next ==null (奇数个节点)
            fast = fast.next.next;
            //slow 指针一次移动1步 
            slow = slow.next;
        }

        //奇数个时 此时slow指针再移动一位  把正中间的归到左边去
        if (fast != null) {
            slow = slow.next;
        }
        //反转一下链表slow指针此时指向的链表
        slow = reverseList(slow);
        //重新还原到开始节点
        fast = head;
        //判断2个链表是否相等 以反转后的slow为遍历的链表
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;

    }


    public ListNode reverseList(ListNode head) {
        /**
         * 链表翻转
         * */
        //当前指针的前一个元素
        ListNode prev = null;
        while (head != null) {
            //将next 节点先存起来  后面使用
            ListNode next = head.next;
            //当前节点的下一个节点本来是指向next的 结果现在就指向了当前节点的前一个节点prev 这里就实现了翻转
            // prev --> cur.next --> next   to  cur.next-->prev 此时cur节点的翻转就完成了
            head.next = prev;
            //prev在下次循环中就已经指向了此时的cur  不断向👉移动
            prev = head;
            //cur在下次循环中就已经指向了此时的next(cur.next)  不断向👉移动
            head = next;
        }
        //此时链表的头节点就是之前的最后一个节点了  而此时的prev就会是最后一个节点 当cur为空时 so return prev
        return prev;
    }

}
