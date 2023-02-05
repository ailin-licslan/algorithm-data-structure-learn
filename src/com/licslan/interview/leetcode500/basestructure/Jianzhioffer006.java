package com.licslan.interview.leetcode500.basestructure;

import java.util.HashMap;

/**
 * @author WEILIN   和leetcode 02 很类似 这里强调了升序
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * 简单
 * 60
 * 相关企业
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * 示例 2：
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * 示例 3：
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 */


public class Jianzhioffer006 {


    private static int[] numList = new int[]{1, 3, 4, 5, 6};

    /**
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * <p>
     * 暴力求解 O(n^2)
     */

    private static int[] getIndex(int[] numList, int target) {


        for (int i = 0; i < numList.length; i++) {

            for (int j = i + 1; j < numList.length; j++) {

                if (numList[i] + numList[j] == target) {

                    int[] intList = new int[2];

                    intList[0] = i;
                    intList[1] = j;

                    return intList;
                }
            }
        }


        return numList;
    }


    //时间复杂度 O(n)  空间复杂度O(n)

    private static int[] getIndex2(int[] numList, int target) {

        int[] targetIndex = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = numList.length;
        for (int i = 0; i < size; i++) {
            int find = target - numList[i];
            if (map.get(find) != null) {
                targetIndex[0] = map.get(find);
                targetIndex[1] = i;
                break;
            }
            map.put(numList[i], i);
        }
        return targetIndex;
    }


    //使用二分法 有序的数组哈

    private static int[] getIndex3(int[] numList, int target) {

        for (int i = 0; i < numList.length; i++) {
            int low = i, high = numList.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numList[mid] == target - numList[i]) {
                    if (mid == i) {
                        return new int[]{i, mid + 1};
                    }
                    return new int[]{i, mid};

                } else if (numList[mid] > target - numList[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[0];

    }


    //双指针写法 L + R 判断 和 target 的大小比较

    private static int[] getIndex4(int[] numList, int target) {

        for (int i = 0; i < numList.length; i++) {
            int left = i, right = numList.length - 1;
            while (i < right) {
                int sum = numList[left] + numList[right];

                if (sum == target) {
                    return new int[]{left, right};
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return new int[0];

    }


    public static void main(String[] args) {
        int[] index = getIndex(numList, 11);
        for (int i : index) {
            System.out.println(i);
        }
        System.out.println(index);
    }

}
