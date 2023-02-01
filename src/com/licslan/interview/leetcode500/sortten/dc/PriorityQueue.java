package com.licslan.interview.leetcode500.sortten.dc;

import com.licslan.datastructure.heap.MaxHeap;
import com.licslan.datastructure.queue.QueueQ;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 */
public class PriorityQueue<E extends Comparable<E>> implements QueueQ<E> {


    //实现优先队列方式
    //普通线性结构  入队:O(1)  出队:O(n)
    //顺序线性结构  入队:O(n)  出队:O(1)
    //堆           入队:O(logn)  出队:O(logn)


    //最大堆   但是jdk中PriorityQueue其实是最小堆结构

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    //优先队列的经典问题  (在N个元素中选出最大/小的k个元素)


    //在100000000个元素中选出前100名？
    // 1.在N个元素中选出前M个元素  排序  Nlogn
    // 2.优先队列  维护当前看到的前M个元素需要使用最小堆 NlogM

    //Leetcode No347 前K个高频元素   给定数组[1,1,1,2,2,3,4,5,6] k=2 返回[1,2]


    //可比较的内部类

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        com.licslan.datastructure.queue.PriorityQueue<Freq> pq = new com.licslan.datastructure.queue.PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().e);
        }
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] numb = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new com.licslan.datastructure.queue.PriorityQueue()).topKFrequent(numb, k));
    }

    /**
     * topK selectK 问题既可以用快排思想解决 又可以用优先队列解决
     *
     * 快排 时间O(n)  空间O(1)
     * 优先队列  时间O(nlogk) 空间O(k)
     *
     * 优先队列优势  不需要一次性知道所有数据  数据流  极大规模数据
     * */

}
