package com.licslan.interview.leetcode500.sortten;

import java.util.Arrays;

/**
 * @author licslan
 * 选择排序
 * 1.首先找出最小和一个元素交换位置
 * 2.再次在剩下的找出最小的和第二元素交换位置
 * 3.依次下去知道最后一个元素
 */
public class SelectSortTest {

    public static int[] selectSortTest(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }


        //外层循环依次循环数组每个下标的元素
        for (int i = 0; i < nums.length; i++) {

            //记录最小值的下标 每个循环开始总是认为第一个元素最小
            int minIndex = i;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    //将最小值索引存下来
                    minIndex = j;
                }
            }

            //找到最小值 和之前的最小值交换位置换成最新的最小值 (每次外层循环开始的第一个元素i交换之前的最小值)
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }
        return nums;

    }

    public static void main(String[] args) {

        int[] test = new int[]{30,20,4,6};
        int[] res = selectSortTest(test);
        String s = Arrays.toString(res);
        System.out.println("========> " + s);
    }
}
