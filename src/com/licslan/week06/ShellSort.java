package com.licslan.week06;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 *
 * 希尔排序  元素间隔越来越小 插入排序
 * */
public class ShellSort {

    private ShellSort(){}

    public static <E extends Comparable<E> > void sort(E[] data){


        //元素之间的间隔是h  每个子数组的元素间隔相差为h
        int h = data.length/2;
        //最外层的循环决定每一轮的写入排序  每一轮h逐渐缩小 知道为1
        while (h >= 1) {
            //每次怎么把data数组分成若干的子数组 进行插入排序呢？
            //start 每一个子数组的起始元素的索引  遍历每一个子数组
            for(int start = 0;start < h; start++){
                //对data[start,start+h,start+2h,start+3h....]进行插入排序    插入排序算法的写法
                for (int i = start+h; i < data.length; i+=h) {
                    //这里需要看data[i]需要插入到子数组的什么地方即可
                    //暂存当前要插入的元素
                    E t=data[i];
                    //要插入的位置我们存在索引j里面
                    int j;
                    for (j = i; j-h >=0 && t.compareTo(data[j-h])<0; j -=h) {
                        data[j] = data[j-h];
                     data[j] = t;

                    }
                }
            }


            //每次缩小2倍
            h /=2;
        }


    }

}
