package com.licslan.interview.leetcode500.sortten;

import java.util.Arrays;

/**
 * @author licslan
 * 插入排序
 * <p>
 * 比较适合小规模数据或者部分有序数据效率较高
 * 找到合适位置插入 之前的位置元素整体向右边移动
 * 重复上面的步骤
 */
public class InsertSortTest {

    public static int[] insertSortTest(int[] nums) {

        if (nums.length == 0) {
            return nums;
        }

        //当前待排序数据 该元素之前的数据认为已经拍好序了
        int currentValue;
        for (int i = 0; i < nums.length - 1; i++) {
            //已经被排序的索引
            int preIndex = i;
            currentValue = nums[preIndex + 1];
            //在已经排序过的数据倒序寻找合适的位置,当前待排序数据比比较的元素要小,将比较的元素后移一位
            while (preIndex >= 0 && currentValue < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            //循环结束 说明找到了合适的位置插入
            nums[preIndex + 1] = currentValue;
        }

        return nums;

    }

    public static void main(String[] args) {

        int[] test = new int[]{30, 20, 4, 6};
        int[] res = insertSortTest(test);
        String s = Arrays.toString(res);
        System.out.println("========> " + s);
    }
}
