package com.licslan.interview.hot100;

import java.util.Arrays;

/**
 * @author WEILIN
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement169 {


    //藏在管子里的蛇，身体长于管子的一半的话，砍中间就肯定能砍到
    //排序后,多数元素数超过长度一半,因此排序后的中间位肯定是多数元素

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
