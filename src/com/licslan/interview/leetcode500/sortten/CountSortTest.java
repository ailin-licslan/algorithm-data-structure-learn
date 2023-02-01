package com.licslan.interview.leetcode500.sortten;

import com.licslan.week01.array.generic.Array;

import java.util.Arrays;

/**
 * @author licslan
 * 计数排序  不比较元素大小的排序算法  局限性只限于整数排序 分布连续跨度较小情况
 */
public class CountSortTest {

    public static int[] countSortTest(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        //寻找数组中最大值 最小值  偏移量 用于定位原始数组每个元素在计数数组中的下标位置
        int bias, min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        bias = 0 - min;
        //计数数组的容量
        int[] countArray = new int[max - min + 1];

        //Assigns the specified int value to each element of the specified array of ints
        Arrays.fill(countArray, 0);

        //遍历原始数组 将原始数组中每个元素值转化为计数数组下标 将计数数组下标对应的元素值大小进行累加
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i] + bias]++;
        }

        //访问原始数组时的下标计数器
        int index = 0;
        //访问计数数组时的下标计数器
        int i = 0;
        //访问计数数组 将计数数组元素转换后 重新写回原始数组
        while (index < nums.length) {
            if (countArray[i] != 0) {
                nums[index] = i - bias;
                countArray[i]--;
                index++;
            } else {
                i++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] a = new int[]{2, 34, 5, 1, 10};
        int[] b = countSortTest(a);
        System.out.println(Arrays.toString(b));

    }

}
