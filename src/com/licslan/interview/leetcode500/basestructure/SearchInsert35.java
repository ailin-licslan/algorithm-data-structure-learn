package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 35. 搜索插入位置
 * 简单
 * 1.9K
 * 相关企业
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class SearchInsert35 {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            //可以找到
            if (nums[i] == target) {
                return i;
            }
            //中间位置
            if ((i < nums.length - 1) && nums[i] <= target && target <= nums[i + 1]) {
                return i + 1;
            }
        }

        //与首位相同或者比首位小
        if (nums[0] >= target) {
            return 0;
        }

        //与末尾相同或者比末尾大
        if (nums[nums.length - 1] <= target) {
            return nums.length;
        }

        return -1;

    }
}
