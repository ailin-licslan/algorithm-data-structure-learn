package com.licslan.interview.link;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * 计算 链表长度  不一样长度的链表可以补位成 0 保证链表长度一致  然后竖式相加
 */
public class Add2Nums {


    public static final int SIZE_NO = 10;

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(List<Integer> arr) {

            if (arr == null || arr.isEmpty()) {
                throw new IllegalArgumentException("arr can not be empty");
            }

            this.val = arr.get(0);
            ListNode cur = this;

            for (int i = 1; i < arr.size(); i++) {

                //一个节点的值 ==10
                if (cur.val >= SIZE_NO) {
                    if (cur.val > SIZE_NO) {
                        cur.val = cur.val - SIZE_NO;
                    } else {
                        cur.val = 0;
                    }
                    cur.next = new ListNode(arr.get(i) + 1);
                    //遍历下一个节点
                    cur = cur.next;
                    continue;
                }


                cur.next = new ListNode(arr.get(i));
                cur = cur.next;
            }


            //处理最后一个元素 最后一个节点==SIZE_NO
            while (cur.val == SIZE_NO) {
                cur.val = 0;
                cur.next = new ListNode(1);
            }
        }


    }


    /**
     * get
     */
    public static ListNode get(List<Integer> arr) {

        if (arr == null || arr.isEmpty()) {
            throw new IllegalArgumentException("arr can not be empty");
        }

        //初始化第一个节点
        ListNode cur = new ListNode(arr.get(0));
        ListNode x = cur;

        //只有一个元素时
        if (arr.size() == 1 && cur.val >= SIZE_NO) {
            if (cur.val > SIZE_NO) {
                cur.val = cur.val - SIZE_NO;
            } else {
                cur.val = 0;
            }
            cur.next = new ListNode(1);
            return x;
        }

        for (int i = 1; i < arr.size(); i++) {

            //一个节点的值==SIZE_NO
            if (cur.val >= SIZE_NO) {

                if (cur.val > SIZE_NO) {
                    cur.val = cur.val - SIZE_NO;
                } else {
                    cur.val = 0;
                }
                cur.next = new ListNode(arr.get(i) + 1);
                //遍历下一个节点
                cur = cur.next;
                continue;
            }

            //其他没有超过的SIZE_NO的
            cur.next = new ListNode(arr.get(i));
            cur = cur.next;

        }


        //处理最后一个元素 最后一个节点==SIZE_NO
        while (cur.val >= SIZE_NO) {
            if (cur.val > SIZE_NO) {
                cur.val = cur.val - SIZE_NO;
                cur.next = new ListNode(1);
                //遍历下一个节点
                cur = cur.next;
            } else {
                cur.val = 0;
                cur.next = new ListNode(1);
            }

        }


        return x;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newNodeList = null;

        //将他们的值遍历过程分别放入到新的容器中
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        while (cur1 != null) {
            list1.add(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            list2.add(cur2.val);
            cur2 = cur2.next;
        }

        //size
        int size1 = list1.size();
        int size2 = list2.size();

        //1.list1 = list2  length
        if (size1 == size2) {
            newNodeList = getNode(list1, list2);
        }

        //2.list1 < list2  length
        if (size1 < size2) {
            for (int i = 0; i < size2 - size1; i++) {
                list1.add(0);
            }
            newNodeList = getNode(list1, list2);
        }

        //3.list1 > list2  length
        if (size1 > size2) {

            for (int i = 0; i < size1 - size2; i++) {
                list2.add(0);
            }
            newNodeList = getNode(list1, list2);
        }


        return newNodeList;
    }


    private static ListNode getNode(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        int size1 = list1.size();
        int size2 = list2.size();

        if (size1 != size2) {
            return null;
        }
        List<Integer> nodeList = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            nodeList.add(list1.get(i) + list2.get(i));
        }

        //return new ListNode(nodeList);
        return get(nodeList);
    }


    public static void main(String[] args) {

//        //[8,2,3]    [9999000]
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(9, l1);
//        ListNode l3 = new ListNode(9, l2);
//        ListNode l4 = new ListNode(9, l3);
//        //ListNode l3 = new ListNode(0, l2);
//
//
//        //[2,1,1]    [9999999]
//        ListNode l11 = new ListNode(9);
//        ListNode l12 = new ListNode(9, l11);
//        ListNode l13 = new ListNode(9, l12);
//        ListNode l14 = new ListNode(9, l13);
//        ListNode l15 = new ListNode(9, l14);
//        ListNode l16 = new ListNode(9, l15);
//        ListNode l17 = new ListNode(9, l16);


        //[8,2,3]    [9]
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9, l1);


        //[2,1,1]    [9]
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9, l11);


        //result [8,1]


        ListNode listNode = addTwoNumbers(l2, l12);
        System.out.println(listNode);
    }
}
