package com.licslan.interview.leetcode500.arrays;

import java.util.Arrays;

public class Lc287FindDuplicate {

    public int findDuplicate(int[] nums) {


        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] - nums[i + 1] == 0 && i + 1 < nums.length) {
                return nums[i];
            }
        }

        return -1;
    }
}
