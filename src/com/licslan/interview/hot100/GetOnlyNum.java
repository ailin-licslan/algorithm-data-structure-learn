package com.licslan.interview.hot100;

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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3};
        System.out.println(getOne(nums));
    }


}
