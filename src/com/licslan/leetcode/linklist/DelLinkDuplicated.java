package com.licslan.leetcode.linklist;

import com.licslan.datastructure.linkedlist.ListNode;

/**
 * @author licslan
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * <p>
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * <p>
 * 思路与算法
 * <p>
 * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
 * <p>
 * 具体地，我们从指针 \textit{cur}cur 指向链表的头节点，随后开始对链表进行遍历。如果当前 \textit{cur}cur 与 \textit{cur.next}cur.next 对应的元素相同，那么我们就将 \textit{cur.next}cur.next 从链表中移除；否则说明链表中已经不存在其它与 \textit{cur}cur 对应的元素相同的节点，因此可以将 \textit{cur}cur 指向 \textit{cur.next}cur.next。
 * <p>
 * 当遍历完整个链表之后，我们返回链表的头节点即可。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-49v5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DelLinkDuplicated {

    public ListNode delDuplicated(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        //遍历 链表
        while (cur.next != null) {

            // 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的
            if (cur.val == cur.next.val) {
                //不指向下个节点  而是指向下个节点的下个节点
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
