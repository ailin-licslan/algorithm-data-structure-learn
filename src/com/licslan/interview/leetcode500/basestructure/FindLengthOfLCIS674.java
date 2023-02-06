package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 674. 最长连续递增序列
 * 简单
 * 356
 * 相关企业
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 */
public class FindLengthOfLCIS674 {


    //贪心算法

    public int findLengthOfLCIS(int[] nums) {

        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {

            //有序数组 后面一个元素比前面的元素小 说明要重新计数了 start
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            //找出后面连续序列里面大的一个留下
            max = Math.max(max, i - start + 1);

        }
        return max;

    }
}
