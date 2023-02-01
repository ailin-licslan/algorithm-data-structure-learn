package com.licslan.interview.leetcode500.sortten;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author licslan
 * 基数排序 不要比较元素大小排序算法
 */
public class RadixSortTest {

    public static int[] radixSortTest(int[] nums) {

        if (nums == null || nums.length < 2) {
            return nums;
        }
        //找出最大数
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        //计算出最大的位数 决定了要做几轮循环
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        //构建桶
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }


        //按照从左至右顺序 依次将每一位当作一次关键字 然后对关键字对数组排序
        //每一轮排序都基于上轮排序结果
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {

            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            //数据写回原始数组 清除桶 准备下一轮的排序
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }

        }

        return nums;
    }

    public static void main(String[] args) {

        int[] a = new int[]{15000, 11, 14, 10, 1, 20};
        int[] b = radixSortTest(a);
        System.out.println(Arrays.toString(b));
    }
}
