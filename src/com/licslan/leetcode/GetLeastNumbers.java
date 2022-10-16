package com.licslan.leetcode;



import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * LeetCode 专栏  ♥  NO40 🗡☞ offer   TOP K 问题
 *
 * @author LICSLAN
 * */
public class GetLeastNumbers {
    
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

        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        //将数组元素中的前k个元素放入优先队列里面去
        for (int i = 0; i < k; i++)
            pq.enqueue(arr[i]);

        for (int i = k; i < arr.length; i++) {
            //保证优先队列不为空
            if(!pq.isEmpty()&& arr[i] < pq.getFront()){  //pq.getFront()堆里面最大的元素
                pq.dequeue();//出队列丢弃
                pq.enqueue(arr[i]);//放入大的
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.dequeue();

        return res;

    }
    
    
}

interface QueueQ<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();


}


class PriorityQueue<E extends Comparable<E>> implements QueueQ<E> {


    //实现优先队列方式
    //普通线性结构  入队:O(1)  出队:O(n)
    //顺序线性结构  入队:O(n)  出队:O(1)
    //堆           入队:O(logn)  出队:O(logn)


    //最大堆   但是jdk中PriorityQueue其实是最小堆结构
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }

    //优先队列的经典问题  (在N个元素中选出最大/小的k个元素)


    //在100000000个元素中选出前100名？
    // 1.在N个元素中选出前M个元素  排序  Nlogn
    // 2.优先队列  维护当前看到的前M个元素需要使用最小堆 NlogM

    //Leetcode No347 前K个高频元素   给定数组[1,1,1,2,2,3,4,5,6] k=2 返回[1,2]



    //可比较的内部类
    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return 1;
            else if(this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

//    public static void main(String[] args) {
//
//        int[] numb = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        printList((new PriorityQueue()).topKFrequent(numb, k));
//    }

}


class MaxHeap<E extends Comparable<E>> {
    private ArrayDynamic<E> data;
    public MaxHeap(int capacity){
        data=new ArrayDynamic<>(capacity);
    }

    public MaxHeap(){
        data = new ArrayDynamic<>();
    }
    //返回堆中的元素个数
    public int size(){
        return data.getSize();
    }
    //堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }
    //返回完全二叉树数组表示 一个索引所表示的元素父节点的索引
    private int parent(int index){
        if(index==0)throw new IllegalArgumentException("index-0 doesn`t have parent");
        return (index-1)/2;
    }
    //返回完全二叉树数组  一个索引所表示的元素左孩子节点索引
    private int leftChild(int index){return index*2+1;}
    //返回完全二叉树数组  一个索引所表示的元素右孩子节点索引
    private int rightChild(int index){return index*2+2;}

    //堆中元素是使用数组组成的  sift up  上浮  形成堆的性质
    // 0    1   2  3  4  5  6  7  8  9 10
    // 62   41 30 28 16 22 13 19 17 15 -

    //像堆中添加元素
    public void add(E e){
        data.addLast(e);
        //添加完成还不够  还需要维护堆的性质
        siftUp(data.getSize()-1);
    }

    //上浮操作
    private void siftUp(int i) {
        //如果不满足堆的性质  就还需要对比
        while (i>0&&data.getIndex(parent(i)).compareTo(data.getIndex(i))<0){
            //不满足堆的性质就交换一下位置
            data.swap(i,parent(i));
            //如果不满足堆的性质  就还需要对比
            i=parent(i);
        }
    }

    //找到堆中最大的元素
    public E findMax(){
        if(data.getSize()==0)throw new IllegalArgumentException("can not findMax when heap is empty!");
        return data.getIndex(0);
    }
    //取出堆中最大的元素
    public E extractMax(){
        E ret=findMax();
        //交换堆中最大的元素和最后一个元素的值
        data.swap(0,data.getSize()-1);
        //将最后一个元素移除掉
        data.removeLast();
        //sift down 下沉
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        //如果左孩子索引比堆元素数量小
        while (leftChild(i)<data.getSize()){
            //说明左孩子是存在的
            int j= leftChild(i);
            //如果右孩子也存在 并且右孩子大于左孩子 （右边>左边）
            if(j+1<data.getSize()&&
                    data.getIndex(j+1).compareTo(data.getIndex(j))>0){
                //右孩子值赋值给j
                j=rightChild(i);
            }
            //data[j]是leftChild & rightChild 中的最大值

            //如果当前元素的值大于等于右孩子(左右孩子最大的一个值)  不违反堆的性质 就不交换了
            if(data.getIndex(i).compareTo(data.getIndex(j))>=0)break;

            //否则就下沉交换一下
            data.swap(i,j);
            //将j赋值给i  进行新一轮循环来比较刚才上述的逻辑操作
            i=j;
        }
    }


    // add  &  extractMax 的时间复杂度都是O(logn)
    // 二叉树高度的这个级别  堆是一颗完全二叉树 永远不会退化为链表的线性结构

    //replace  取出最大元素后  放入一个新元素
    // 实现方案一：  先exarctMax 再 add 两次O(logn)
    // 实现方案二：  可以直接将堆顶元素替换以后siftDown 一次O(logn)

    //取出堆中最大元素  并且替换成元素e
    public E replace(E e){
        E ret=findMax();
        //替换
        data.set(0,e);
        //下沉
        siftDown(0);
        return ret;
    }

    //Heapify  将任意数组整理成堆的形状
    // 实现方案一：  将数组中N个元添加到我们实现的heap结构的对象中就可以了  O(logn)
    // 实现方案二：  将当前数组看成是一颗完全二叉树 从最后一个非叶子节点不断向前siftDown就行了  O(n)

    //Heapify
    public MaxHeap(E[] arr){
        data=new ArrayDynamic<>(arr);
        //将当前数组看成是一颗完全二叉树 从最后一个非叶子节点不断向前siftDown就行了  O(n)
        if(arr.length != 1){
            for(int i=parent(arr.length-1);i>=0;i--)
                siftDown(i);
        }
    }

}


class ArrayDynamic<E> {

    //LICSLAN  day1 数组学习  数据结构   这个时候开始学习  算法与数据结构!!!  <之前一直没有下决心学数据结构和算法>

    //数据库CRUD 我们对自己封装的数组也进行相应的内存级别的CRUD   动态数组学习 用户不能知道底层做了什么操作

    //定义一个空数组
    private E[] data;
    //数组实际大小  私有成员变量
    private int size;

    //获取数组元素个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getcapacity(){
        return data.length;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //初始化空数组 构造函数  传入数组容量
    public ArrayDynamic(int capacity){
        data=(E[]) new Object[capacity];
        size=0;
    }

    public ArrayDynamic(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i]=arr[i];
        size=arr.length;
    }
    //无参构造函数
    public ArrayDynamic(){
        this(10);
    }

    //向指定元素位置插入元素  那么指定元素位置后面的元素需要往后移动
    public void add(int index,E e){
        /*if(size==data.length)
            throw new IllegalArgumentException("array is full");*/
        if(index<0||index>size)
            throw new IllegalArgumentException("Require index>=0 and index < size");
        if(size==data.length)
            //这个时候不是报错了  而是扩容 2倍 1.5  3都可以
            resize(2*data.length);

        //移动元素  从最后的开始  也就是从后往前元素一次都往后移动一位
        for(int i=size-1;i>=index;i--)
            //将大于等于index的值往后依次移动一位元素
            data[i+1]=data[i];
        //此时data[index]的值赋值为要插入的值
        data[index]=e;
        size++;

    }

    //获取指定元素的位置
    public E getIndex(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Get failed! Index is illegal");
        return data[index];
    }

    private void resize(int newCapacity) {
        //申明一个新的数组  并将原来数组的值赋值到新的数组里面来
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];

        //将data指向新的数组newData  那么以前的data数组JVM gc自己自动回收了
        data=newData;

    }

    //修改指定元素的值
    public void set(int index,E e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Set failed! Index is illegal");
        data[index] = e;
    }

    public void addLast(E i) {
        add(size,i);
    }



    //删除指定索引位置的元素  动态删除  当删除到一定程度的时候  数组的容量capacity就会自动缩小
    public E remove(int index){
        E indexValue= data[index];
        if(index<0||index>=size)
            throw new IllegalArgumentException("Remove failed! Index is illegal");

        //将索引大于index的值都往前移动一位  从index索引下一位开始移动
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;

//        if(size==data.length/2)
//            resize(data.length/2);

        //上述的动态数组缩容时优化 缩容时不能为0  空数组长度不能为0啊
        if(size==data.length/4 && data.length/2!=0)
            resize(data.length/2);

        return indexValue;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for(int i =0;i<size;i++){
            res.append(data[i]);
            //如果不是最后一个元素
            if(i!=size-1)
                res.append(",");
        }
        //如果是最后一个元素
        res.append("]");
        return res.toString();
    }

    //查找元素的索引值  如果找不到就返回-1  当然这里也只是找了一个元素e  并没有找到所有元素e
    public int findIndex(E e){
        for(int i=0;i<size;i++){
            if(data[i]==e){
                //返回索引值
                return i;
            }
        }
        return -1;
    }

    //删除第一位
    public E removeFirst(){
        return remove(0);
    }
    //删除最后一位
    public E removeLast(){
        return remove(size-1);
    }
    //删除某个元素  如果有重复元素并不能保证完全删除元素e
    public void removeE(E e){
        //首先找一下元素的索引位置
        int index = findIndex(e);
        if(index!=-1)
            remove(index);
    }

    //交换动态数组里面的两个索引分别为i & j的值
    public  void swap(int i,int j){
        if(i<0||i>=size||j<0||j>=size) throw new IllegalArgumentException("Index is illegal");
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }


    //时间复杂度分析  O(1)  O(n)  O(lgn) O(nlogn) O(n^2)

    //时间复杂度 忽略常数

    // T=2*N+2                 O(n)
    // T=2000*N+10000          O(n)
    // T=1*N*N + 0.00001       O(n^2)

    //渐进时间复杂度 描述当N趋近于无穷时的情况

    //[添加操作]
    //addLast()  O(1)  resize()  O(n)
    //addFirst() O(n)
    //add(index,e)  可能是  如果index==size O(1) 也有可能是O(n) index=0   计算数学期望  平均而言 O(N/2)=O(N)
    //动态数组  resize()操作  O(N)
    //[删除操作]
    //removeLast()  O(1)
    //removeFirst() O(n)
    //remove(index,e)  可能是  如果index==size O(1) 也有可能是O(n) index=0   计算数学期望  平均而言 O(N/2)=O(N)
    //[修改操作]
    //set() O(1)
    //[查询操作]
    //get(index) O(1)
    //contains(e) O(n)
    //find(e)  O(n)


    //总结一下数组的时间复杂度
    //add    O(n)     resize()
    //delete O(n)     resize()
    //update 已知索引 O(1)  未知索引O(n)
    //query  已知索引 O(1)  未知索引O(n)


    //算法领域时间复杂度通常按照最坏的考虑

    //复杂度震荡 removeLast and addLast to  Eager  so we should lazy   扩容 缩小    当size==capacity/4 才将capacity减半

}