package com.licslan.week06;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 */
public class BubbleSort {

    private BubbleSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        //遍历n-1轮 最后一轮没有相邻元素比较了
        for (int i = 0; i + 1 < data.length; i++) {
            //arr[n-1,n]已经排好序了
            //通过冒泡再arr[n-i-1]位置放上合适的元素
            for (int j = 0; j + 1 <= data.length - i - 1; j++) {
                //j , j+1  前面的元素大于后面的元素  就交换
                if (data[j].compareTo(data[j + 1]) > 0) {

                    swap(data, j, j + 1);
                }
            }
        }
    }

    //交换位置元素
    private static <E> void swap(E[] data, int j, int i) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
