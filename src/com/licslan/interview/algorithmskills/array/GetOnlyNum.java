package com.licslan.interview.algorithmskills.array;

import java.util.*;

public class GetOnlyNum {


    public static int getOne(int[] nums) {
        if (!(nums.length > 0)) {
            //not found yet
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();


        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                //System.out.println(num + "=====");
                map.put(num, 2);
            } else {
                //System.out.println(num);
                map.put(num, 1);
            }
        }


        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            Integer key = x.getKey();
            Integer value = x.getValue();
            if (value == 1) return key;
        }


        return -1;
    }

    public static int getOne2(int[] nums) {
        //先排序一下
        Arrays.sort(nums);
        int slow = 0, fast = slow + 1;
        while (slow < nums.length - 1) {
            //相邻的元素肯定是相同的成对出现   每次移动2格就是相同的  否则就会落单不是成对出现
            if (nums[slow] == nums[fast]) {
                slow = slow + 2;
                fast = fast + 2;
            } else {
                return nums[slow];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(getOne2(nums));
    }


}
