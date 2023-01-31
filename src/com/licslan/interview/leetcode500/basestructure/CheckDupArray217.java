package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author licslan
 * 专栏  ♥  NO217
 * <p>
 * 17. 存在重复元素
 * 简单
 * 900
 * 相关企业
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */
public class CheckDupArray217 {


    //超出时间限制

    public static boolean containsDuplicate(int[] nums) {


        if (nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;

    }


    public static boolean containsDuplicate2(int[] nums) {


        if (nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;

    }


    public static boolean containsDuplicate3(int[] nums) {


        if (nums.length <= 1) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            /**
             * Adds the specified element to this set if it is not already present.
             * More formally, adds the specified element <tt>e</tt> to this set if
             * this set contains no element <tt>e2</tt> such that
             * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>.
             * If this set already contains the element, the call leaves the set
             * unchanged and returns <tt>false</tt>.
             *
             * @param e element to be added to this set
             * @return <tt>true</tt> if this set did not already contain the specified
             * element
             * so if existed element already will return false
             */
            if (!hashSet.add(num)){
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[] test = new int[]{4, 1, 1, 3};
        boolean b = containsDuplicate(test);
        System.out.println(b);
    }
}
