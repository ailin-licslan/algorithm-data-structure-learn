package com.licslan.interview.leetcode500.dynamicprogramming;

/**
 * @author licslan
 * 53. 最大子数组和
 * 中等
 * 5.7K
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArray53 {


    //DP 写法

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {

            //遍历开始 每次相加后取较大的值  当前元素  和 相邻2个元素相加之后的值
            pre = Math.max(pre + x, x);

            //找到最大值
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    //贪心算法写法


}
