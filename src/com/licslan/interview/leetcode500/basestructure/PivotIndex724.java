package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;

/**
 * @author licslan
 * <p>
 * 724. 寻找数组的中心下标
 * 简单
 * 512
 * 相关企业
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 */
public class PivotIndex724 {

    public static int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum) {
                return i;
            }
            sum = sum - nums[i];
        }
        return -1;
    }


    //思路2 2*sum+cur = toTal

    public static int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            //后计算一次
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex2(new int[]{1, 7, 3, 7, 1}));
    }
}
