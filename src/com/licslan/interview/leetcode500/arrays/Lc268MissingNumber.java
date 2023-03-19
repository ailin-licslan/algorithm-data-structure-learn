package com.licslan.interview.leetcode500.arrays;

import java.util.Arrays;

public class Lc268MissingNumber {

    public static int missingNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[0] == 1) return 0;
            //0,1,2
            if (nums[i] - i != 0 && i - 1 < nums.length && i - 1 > 0) {
                return nums[i - 1] + 1;
            }

            //The length not in range
            if (nums.length != nums[nums.length - 1]) {
                return nums.length;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int i = missingNumber(nums);
        System.out.println(i);
    }
}
