package com.licslan.interview.leetcode500.basestructure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author licslan
 */
public class ThreeSumClosest16 {


    //双指针思路
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length <= 2) return null;

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


    public int threeSumClosest(int[] nums, int target) {

        if ((nums.length < 3)) {
            throw new RuntimeException("length can not less 3!");
        }

        Arrays.sort(nums);

        //假设答案是这个 排序了   所以相加是一个最小值
        int findValue = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {

            //定义双指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {

                int temp = nums[i] + nums[right] + nums[left];

                //如果接着找到  那么就是最接近的了
                if (temp == target) {
                    return target;
                } else {

                    //比如  target=5  findValue = 7 temp = 6  确实是 6和7 更加接近
                    if (Math.abs(temp - target) < Math.abs(findValue - target)) findValue = temp;
                    else if (temp > target) right--;
                    else {
                        left++;
                    }

                }

            }


        }


        return findValue;

    }


}
