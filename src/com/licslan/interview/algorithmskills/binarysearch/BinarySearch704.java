package com.licslan.interview.algorithmskills.binarysearch;

/**
 * @author licslan
 */
public class BinarySearch704 {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {

        //循环不变量 nums[l,r]范围中不断去查找target
        while (l <= r) {

            //找到中间位置元素下标
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        return -1;
    }


    //递归写法

    private int searchR(int[] data, int target, int l, int r) {
        //空数组
        if (l > r) {
            return -1;
        }
        //找到中间位置元素下标
        int mid = l + (r - l) / 2;
        //正好相等
        if (data[mid] == target) {
            return mid;
        }
        //去左侧找  因为中间元素>target
        if (data[mid] > target) {
            return searchR(data, target, l, mid - 1);
        }
        //否则就去右边找
        return searchR(data, target, mid + 1, r);
    }


}
