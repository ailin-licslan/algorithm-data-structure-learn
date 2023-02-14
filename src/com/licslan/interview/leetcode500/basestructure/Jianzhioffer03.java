package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author licslan
 * 剑指 Offer 03. 数组中重复的数字
 * 简单
 * 1.1K
 * 相关企业
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Jianzhioffer03 {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        //双指针
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                return nums[i];
            }
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
