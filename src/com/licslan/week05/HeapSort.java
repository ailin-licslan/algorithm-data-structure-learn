package com.licslan.week05;


import com.licslan.week00.ArrayGenerator;

import java.util.Arrays;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class HeapSort {

    /**
     * 堆排序  extractMax  取出堆元素中最的值  O(nlogn)
     * */
    private HeapSort(){}
    public static <E extends Comparable<E>> void sort(E[] data){

        //其实就是将数组中的元素遍历放到堆里面 再来进行一个排序就可以了
        MaxHeap<E> maxHeap = new MaxHeap<>();

        //将元素放入最大堆中
        for (E e:data) {
            maxHeap.add(e);
        }  // O(nlogn)
        //将元素排序放入原数组中
        for (int i = data.length - 1; i >=0; i--) {
            data[i] = maxHeap.extractMax();
        } // O(nlogn)
    }





    //堆排序的优化  以上多开辟一个数组的空间  其实可以实现原地堆排序的  不用多开数组空间  空间复杂度O(1)
    //其实我们将堆最后的元素和最大元素交换位置之后进行siftDown形成新的堆就可以  最后面的元素就是从小到大排好序了
    public static <E extends Comparable<E>> void sort2(E[] data){
        if (data.length<=1)return;
        for (int i = (data.length - 1-1)/2; i >=0; i--) {
            siftDown(data,i,data.length);
        }


        for (int i=data.length - 1; i >= 0; i--){
            swap(data,0,i);
            siftDown(data,0,i);
        }
    }

    //对data[0,n)所形成的最大堆中，索引为 k 的元素 执行siftDown
    private static <E extends Comparable<E> > void siftDown(E[] data, int k,int n) {
        //如果左孩子索引比堆元素数量小
        while (2*k+1<n){
            //说明左孩子是存在的
            int j= 2*k+1;
            //如果右孩子也存在 并且右孩子大于左孩子 （右边>左边）
            if(j+1<n&&
                    data[j+1].compareTo(data[j])>0){
                //右孩子值赋值给j
                j++;
            }
            //data[j]是leftChild & rightChild 中的最大值

            //如果当前元素的值大于等于右孩子(左右孩子最大的一个值)  不违反堆的性质 就不交换了
            if(data[k].compareTo(data[j])>=0)break;

            //否则就下沉交换一下
            swap(data,k,j);
            //将j赋值给i  进行新一轮循环来比较刚才上述的逻辑操作
            k=j;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }


//    //返回完全二叉树数组表示 一个索引所表示的元素父节点的索引
//    private int parent(int index){
//        if(index==0)throw new IllegalArgumentException("index-0 doesn`t have parent");
//        return (index-1)/2;
//    }
//    //返回完全二叉树数组  一个索引所表示的元素左孩子节点索引
//    private int leftChild(int index){return index*2+1;}
//    //返回完全二叉树数组  一个索引所表示的元素右孩子节点索引
//    private int rightChild(int index){return index*2+2;}


    public static void main(String[] args) {
        Integer[] items = new Integer[]{22,1,11,2,4,57,6};
        sort(items);
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }


        System.out.println("===================================================");

        int n = 1000000;  //一百万数据测试  对比

        Integer[] arr = ArrayGenerator.arrayRandomGenerator(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);
        Integer[] arr5 = Arrays.copyOf(arr,arr.length);


        SortingHelper.testSort("MergeSort",arr2);
        SortingHelper.testSort("QuickSort2Ways",arr2);
        SortingHelper.testSort("QuickSort3Ways",arr3);
        SortingHelper.testSort("HeapSort",arr4);
        SortingHelper.testSort("HeapSort2",arr5);
    }
}
