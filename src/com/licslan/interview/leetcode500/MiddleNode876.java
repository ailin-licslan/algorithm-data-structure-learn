package com.licslan.interview.leetcode500;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author licslan
 * 876. 链表的中间结点
 * 简单
 * 779
 * 相关企业
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleNode876 {

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode cur = head;
        int length = 0;

        //计算长度
        while (head != null) {
            head = head.next;
            length++;
        }


        //等于1 直接返回
        if (length == 1) {
            return cur;
        }

        //移动 length/2 的节点数返回即可
        for (int i = 0; i < length / 2; i++) {
            cur = cur.next;
        }

        return cur;
    }


    //快慢指针方式

    public ListNode middleNode2(ListNode head) {

        ListNode fast = head, slow = head;

        //如果一直没有移到最后一位 奇数个数  偶数个数
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //循环完了 就找到了要返回的节点
        return slow;

    }


}
