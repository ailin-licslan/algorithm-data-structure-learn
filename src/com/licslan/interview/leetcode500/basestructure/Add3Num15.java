package com.licslan.interview.leetcode500.basestructure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author licslan
 */
public class Add3Num15 {


    //双指针思路
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) return null;

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> res2 = new HashSet<>();

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //排序后 第一个数如果大于0  就不用继续下去了
            if (nums[0] > 0) break;

            //重复排除
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //定义一个目标值 为任意2个数相加的结果的相反数
            int target = -nums[i];
            //定义2个指针   left 指针 向右移动  right指针向左移动
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                //找到目标情况
                if (nums[left] + nums[right] - target == 0) {
                    res2.add(new ArrayList<>(Arrays.asList(nums[i], nums[right], nums[left])));
                    //left 指针 向右移动  right指针向左移动
                    left++;
                    right--;
//                    //里面如果有重复的数字也需要排除
//                    while (left < right && nums[left] == nums[left - 1]) left++;
//                    while (left < right && nums[right] == nums[right + 1]) right++;
                } else if (nums[left] + nums[right] - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }


        }

        return res2.stream().collect(Collectors.toList());

    }
}
