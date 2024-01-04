package com.licslan.interview.link;

import com.licslan.interview.hot100.utils.ListNode;

/**
 * @author WEILIN
 *
 * LeetCode 专栏  ♥  NO142
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * ******在141基础上面升级  有环之后  需要找到最初的入环节点  后面就是让2个指针移动速度一致都移动一个节点 慢指针从头节点开始移动  后面2个指针再次相遇就是入环节点了
 *
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
public class HasCycleStartPoint142 {


    //福洛伊德解法

    public ListNode hasCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //是否有环
        boolean hasLoopNode = false;
        while (fast != null && fast.next != null) {
            //fast指针 先走2步每次 slow指针移动一步每次
            fast = fast.next.next;
            slow = slow.next;

            //相等说明有环了
            if (slow == fast) {
                hasLoopNode = true;
                break;
            }
        }


        if (hasLoopNode){

            //让慢指针从头节点开始移动
            slow = head;

            while (fast != slow){
                //后面就是让2个指针移动速度一致都移动一个节点
                fast = fast.next;
                slow = slow.next;
            }

            //说明相等了 后面2个指针再次相遇就是入环节点了
            return  slow;
        }



        //环不存在
        return null;
    }

}



