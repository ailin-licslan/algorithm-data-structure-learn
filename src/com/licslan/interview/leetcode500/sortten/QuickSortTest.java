package com.licslan.interview.leetcode500.sortten;

import java.util.Arrays;

/**
 * @author licslan   面试常考快速 归并 堆排序
 * 快速排序对冒泡排序的一种优化 同时还有分治的思想在里面
 * 和一个基准数比较  大的放左边  小的放右边  排好之后   将分区的左右的2部分数据再安装相同的方法进行比较 ...
 * 重复上面的步骤
 * A 如果当前元素小于等于基准数时 首先分割指示器右移动一位
 * B 在A的基础上， 如果当前元素下标大于分割指示器下标时 当前元素和分割指示器元素交换位置
 */
public class QuickSortTest {


    //基准数的选取 最优情况是基准值刚好在无序去掉中间位置 提高排序效率减少递归次数 一般比较难
    //基准数的选取方式
    //1.数组的初始位
    //2.数组的末尾
    //3.中间位置数与初始位 末位数得到的中位数作为基准数

    //JDK DualPivotQuicksort.sort 双轴快速排序 一般时间上可以提升10%的效率 里面是选了2个基准数 分了3个部分

    public static int[] sortArray(int[] nums) {
        //Arrays.sort(nums);
        return sort(nums, 0, nums.length - 1);
    }

    private static int[] sort(int[] array, int start, int end) {

        if (array.length < 1 || start < 0 || end > array.length || start > end) {
            return new int[0];
        }

        //数据分割成2个部分  从哪分区的指示器  调用快速排序的分区方法
        int zoneIndex = partition(array, start, end);

        //左半部分
        if (zoneIndex > start) {
            sort(array, start, zoneIndex - 1);
        }

        //右半部分
        if (zoneIndex < end) {
            sort(array, zoneIndex + 1, end);
        }
        return array;
    }


    //假设数组 35 63 48 9 86 24 53 11

    private static int partition(int[] array, int start, int end) {

        //只有一个元素时 无需再排序
        if (start == end) {
            return start;
        }
        //随机选一个基准数 48
        int pivot = (int) (start + Math.random() * (end - start + 1));

        //zoneIndex是分区指示器 初始值为分区头元素下标-1   首次循环时zoneIndex = -1
        int zoneIndex = start - 1;

        System.out.println("开始下标：" + start + " ,结束下标： " + end + ", 基准数下标： "
                + pivot + ", 元素值： " + array[pivot] + " 分区指示器下标 " + zoneIndex);

        //将基准数和分区末尾元素交换位置  48 与 11 交换一下
        swap(array, pivot, end);

        //35 63 11 9 86 24 53 48
        for (int i = start; i <= end; i++) {
            //当前元素<=基准数
            if (array[i] <= array[end]) {
                //分区指示器+1
                zoneIndex++;
                //当前元素在分区指示器的右边时 交换当前元素(遍历指示器元素)和分区指示器元素
                if (i > zoneIndex) {
                    swap(array, i, zoneIndex);
                }
            }
            System.out.println("分区指示器：" + zoneIndex + " 遍历指示器：" + i);

        }
        System.out.println("---------------------");
        return zoneIndex;
    }

    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void main(String[] args) {

        ////假设数组 35 63 48 9 86 24 53 11
        int[] test = new int[]{35, 63, 48, 9, 86, 24, 53, 11};

        //DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0); 双轴快速排序 分为3个部分

        //数量<286选用  插入排序方法

        Arrays.sort(test);

        //sortArray(test);
        String s = Arrays.toString(test);

        System.out.println("========> " + s);

    }


}
