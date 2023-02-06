package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 643. 子数组最大平均数 I
 * 简单
 * 281
 * 相关企业
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 */
public class FindMaxAverage643 {


    /*滑动窗口 双指针以一定的间距移动 移动速度相同 和快慢指针有点不一样*/


    //滑动窗口

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        //先计算第一个窗口的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }


        //滑动窗口 找出移动的关系 进去一个值 出去一个值
        int max = sum;
        for (int i = k; i < n; i++) {
            //减第一个元素 + 加上往后移动一位的元素
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return 1.0 * max / k;
    }
}
