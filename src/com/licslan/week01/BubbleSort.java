package com.licslan.week01;

import java.util.Arrays;

/**
 * @author licslan
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = {123,1,2321,123,11,10,112};
        int[] ints1 = bubbleSort(ints);
        int[] ints2 = bubbleSort(ints1);
        printList(bubbleSort(ints2));
        System.out.println(Arrays.asList(ints2));
    }

    public static void printList(int[] ints){


        for (int i = 0; i < ints.length; i++) {
            if (i==ints.length-1){
                System.out.println(ints[i]+"]");
            }else if(i==0){
                System.out.println("["+ints[i]+",");
            }else {
                System.out.println(ints[i]+",");
            }
        }
    }

    /**12, 13, 15, 16*/
    public static int[] bubbleSort(int[] ints) {
        //控制外层循环次数
        for (int i = 0; i < ints.length - 1; i++) {


            //控制内存循环
            for (int j = 0; j < ints.length - i - 1; j++) {

                //从小到大排  大的值往右边挪动  如果自己比右边的数大就交换一下位置
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }

        }
        return ints;
    }

}
