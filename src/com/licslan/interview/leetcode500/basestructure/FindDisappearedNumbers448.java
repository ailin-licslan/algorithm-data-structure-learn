package com.licslan.interview.leetcode500.basestructure;

import java.util.*;

/**
 * @author WEILIN
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果
 */
public class FindDisappearedNumbers448 {


    //下面方式 用例不过  超出时间限制了

    public static List<Integer> findDisappearedNumbers(int[] nums) {


        if ((nums == null || nums.length <= 1)) {

            return Collections.emptyList();
        }

        List<Integer> disNum = new ArrayList<>();


        List<Integer> numList = new ArrayList<>(nums.length);

        for (int num : nums) {
            numList.add(num);
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (!numList.contains(i)) {
                disNum.add(i);
            }
        }

        return disNum;

    }


    public List<Integer> findDisappearedNumbersV2(int[] nums) {

        //1.去重一下
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();

        //2.角标不在set里面的就是你要找的数据 装到新集合返回就行
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }


    public List<Integer> findDisappearedNumbers3(int[] nums) {

        int n = nums.length;
        for (int num : nums) {
            //对取模还原本来的值 找下标
            int x = (num - 1) % n;
            nums[x] += n;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            //找到小于n的就是消失的数字
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums2);
        System.out.println(disappearedNumbers);
    }
}
