package com.licslan.interview.hot100;

import java.util.Stack;

/**
 * @author WEILIN
 * 判断回文链表
 * 从左到右  和  从右到左一样
 * https://leetcode.cn/problems/palindrome-number/
 */
public class IsPalindrome234 {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        //先入栈
        while (cur != null) {
            stack.push(cur.val);
            //指向下一个元素遍历
            cur = cur.next;
        }

        //遍历时和栈里面的取值相等就行 就是回文的了
        while (head != null) {
            //不相等就不是回文的了
            if (stack.pop() != head.val) {
                return false;
            }
            //指向下一个元素遍历
            head = head.next;
        }

        //都遍历完了  说明肯定是回文的了
        return true;
    }

}


