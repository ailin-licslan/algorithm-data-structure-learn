package com.licslan.interview.leetcode500.basestructure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author licslan
 * 349. 两个数组的交集
 * 简单
 * 726
 * 相关企业
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class Intersection349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> res = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> findList = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (res.contains(nums1[i])) {
                findList.add(nums1[i]);
            }
        }
        return findList.stream().mapToInt(Integer::intValue).toArray();
    }
}
