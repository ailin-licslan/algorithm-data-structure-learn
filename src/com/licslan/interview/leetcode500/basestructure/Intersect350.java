package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author licslan
 * 350. 两个数组的交集 II
 * 简单
 * 911
 * 相关企业
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class Intersect350 {


    public int[] intersect(int[] nums1, int[] nums2) {
        //num1.length < num2.length
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //记录nums1每个元素出现的次数
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;

        for (int num : nums2) {
            //num1里面已经存了之前的元素出现的次数
            int count = map.getOrDefault(num, 0);

            //如果能找到 num2与 num1中相同的元素
            if (count > 0) {
                //就往最终结果集存一下结果
                intersection[index++] = num;
                //count数减一次
                count--;
                //如果还大于零更新次数
                if (count > 0) {
                    map.put(num, count);
                } else {
                    //移除该元素
                    map.remove(num);
                }
            }
        }

        //最后复制需要的结果
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
