package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;

/**
 * @author licslan
 * 628. 三个数的最大乘积
 * 简单
 * 423
 * 相关企业
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 */
public class MaxInThree628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }


    //线性扫描思路

    public int maximumProduct2(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            //最小值
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            //求最大值
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }


}
