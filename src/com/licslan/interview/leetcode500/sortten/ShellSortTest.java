package com.licslan.interview.leetcode500.sortten;

/**
 * @author LICSLAN 下定决心学算法与数据结构
 * <p>
 * 希尔排序  元素间隔越来越小 插入排序
 * <p>
 * 基于插入排序的快速排序算法  缩小增量排序 也是冲破O(n^2)的第一批算法之一
 */
public class ShellSortTest {

    private ShellSortTest() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        //元素之间的间隔是h  每个子数组的元素间隔相差为h
        int h = data.length / 2;
        //最外层的循环决定每一轮的写入排序  每一轮h逐渐缩小 知道为1
        while (h >= 1) {
            //每次怎么把data数组分成若干的子数组 进行插入排序呢？
            //start 每一个子数组的起始元素的索引  遍历每一个子数组
            for (int start = 0; start < h; start++) {
                //对data[start,start+h,start+2h,start+3h....]进行插入排序    插入排序算法的写法
                for (int i = start + h; i < data.length; i += h) {
                    //这里需要看data[i]需要插入到子数组的什么地方即可
                    //暂存当前要插入的元素
                    E t = data[i];
                    //要插入的位置我们存在索引j里面
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                        data[j] = t;

                    }
                }
            }
            //每次缩小2倍
            h /= 2;
        }
    }


    //常用的增量序列
    //希尔增量序列  折半 {N/2,(N/2)/2,...1}
    //Hibbard序列  {2^k-1...,3,1}
    //Sedgwick序列 {挺复杂^_^}


    public static int[] shellSortTest(int[] nums) {

        if (nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        //按增量分组 每个分组中 temp表示当前排序数组 该元素之前的数据认为已经拍好序了

        //gap指用来分组的增量 一次递减
        int currentValue, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                //已经被排序的索引
                int preIndex = i - gap;
                currentValue = nums[i];
                //在已经排序过的数据倒序寻找合适的位置,当前待排序数据比比较的元素要小,
                //将比较的元素后移一位
                while (preIndex >= 0 && currentValue < nums[preIndex]) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                //循环结束 说明找到了合适的位置插入
                nums[preIndex + gap] = currentValue;
            }

            //每次缩小2倍
            gap /= 2;
        }


        return nums;

    }

}
