package com.licslan.interview.leetcode500.sortten;

/**
 * @author licslan
 * 冒泡排序
 * 相邻 2 个元素 两两比较 然后交换位置
 */
public class BubbleSortTest {

    //O(n^2)

    public int[] sortBubbleTest(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {

            //优化: 减i 是后面的i次已经排好序了 可以减少循环比较次数
            for (int j = 0; j < nums.length - i - 1; j++) {
                //swap一下 后面小于前面的 就相互换一下位置
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}
