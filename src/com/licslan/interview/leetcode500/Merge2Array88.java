package com.licslan.interview.leetcode500;

import java.util.Arrays;

/**
 * @author licslan
 * 88. 合并两个有序数组
 * 简单
 * 1.7K
 * 相关企业
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Merge2Array88 {


    //时间复杂度 O((m+n)log(m+n))

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        //快速排序法
        Arrays.sort(nums1);
    }


    //method 2 O(m+n)

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] temp = new int[k];

        // m有可能和n不相等
        for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
            //nums1 数组取完了 完全取nums2的值
            if (nums1Index >= m) {
                temp[index] = nums2[nums2Index++];
            }
            //nums2 数组取完了 完全取nums1的值
            else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index++];
            }
            //nums1 数组的元素小于 nums2的 取nums1数组的值
            else if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[index] = nums1[nums1Index++];
            }
            //nums2 数组的元素小于等于 nums1左边数组 取nums2数组的值
            else {
                temp[index] = nums2[nums2Index++];
            }
        }

        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }

    }


    //method 3  时间复杂度O(m+n)  空间复杂度O(1)  避免引入 m+n大小的临时数组

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        // m有可能和n不相等
        for (int index = k-1, nums1Index = m-1, nums2Index = n-1; index >=0; index--) {

            //nums1 数组取完了 完全取nums2的值
            if (nums1Index <0) {
                nums1[index] = nums2[nums2Index--];
            }
            //nums2 数组取完了 完全取nums1的值
            else if (nums2Index < 0) {
                break;
            }
            //nums1 数组的元素大于 nums2的 取nums1数组的值
            else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            }
            //nums2 数组的元素大于等于 nums1 取nums2数组的值
            else {
                nums1[index] = nums2[nums2Index--];
            }
        }
    }


}
