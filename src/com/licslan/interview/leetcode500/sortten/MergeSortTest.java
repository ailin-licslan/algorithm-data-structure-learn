package com.licslan.interview.leetcode500.sortten;

import java.util.Arrays;

/**
 * @author licslan
 * 归并排序算法  面试常考快速 归并 堆排序
 * <p>
 * 对应给定的数组 利用递归+分治将数据分为越来越小的半子表 在对半字表排序后
 * 再用递归将排序好的半子表合并为越来越大的有序序列
 */
public class MergeSortTest {

    public static int[] mergeSortTest(int[] nums) {

        //35, 63, 48, 9
        if (nums.length < 2) {
            return nums;
        }

        //切分数组
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        //递归排序 merge合并
        return merge(mergeSortTest(left), mergeSortTest(right));
    }

    //将排序好的2段排序好的数组合成一个排序数组

    private static int[] merge(int[] left, int[] right) {
        //声明一个空白数组
        int[] result = new int[left.length + right.length];

        for (int index = 0, i = 0, j = 0; index < result.length; index++) {

            //左边数取完  完全取右边数组
            if (i >= left.length) {
                result[index] = right[j++];
            }
            //右边数取完  完全取左边数组
            else if (j >= right.length) {
                result[index] = left[i++];
            }
            //左> 右  取右边的值 谁大就放到空白数组里面
            else if (left[i] > right[j]) {
                result[index] = right[j++];
            }
            //右> 左  取左边的值 谁大就放到空白数组里面
            else {
                result[index] = left[i++];
            }

        }

        return result;
    }


    public static void main(String[] args) {

        int[] test = new int[]{35, 63, 48, 9, 86, 24, 53, 11};
        //int[] left = Arrays.copyOfRange(test, 0, 4);
        int[] a = mergeSortTest(test);
        String s = Arrays.toString(a);
        System.out.println(s);

    }
}
