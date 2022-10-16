package com.licslan.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
/**
 * LeetCode 专栏  ♥  NO40 🗡☞ offer   TOP K 问题
 *
 * @author LICSLAN
 * */
public class GetLeastNumbersByJDKPriorityQueue {
    
    /**
     * 剑指 Offer 40. 最小的K个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     *
     *
     * 限制：
     *
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     *
     * 优先队列去实现 MaxHeap来实现
     * */


    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<> (Collections.reverseOrder());
        //将数组元素中的前k个元素放入优先队列里面去
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            //保证优先队列不为空
            if(!pq.isEmpty()&& arr[i] < pq.peek()){  //pq.getFront()堆里面最大的元素
                pq.remove();//出队列丢弃
                pq.add(arr[i]);//放入大的
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.remove();

        return res;

    }
    
    
}

