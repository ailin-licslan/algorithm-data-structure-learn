package com.licslan.interview.algorithmskills.array;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * */
public class TwoSum167 {

    public int[] twoSum(int[] numList, int target) {

        //双指针  左右指针  左边小  左边大  相对移动

        int left = 0, right = numList.length - 1;

        while (left < right) {

            int sum = numList[left] + numList[right];
            if (sum == target) {
                //索引+1
                return new int[]{left+1, right+1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return new int[]{-1, -1};

    }
}
