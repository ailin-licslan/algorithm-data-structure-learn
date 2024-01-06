package com.licslan.interview.algorithmskills.array;

public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        //双指针写法  只要找到不等于的统计就加一

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }
}
