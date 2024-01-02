package com.licslan.interview.hot100;

import java.util.Arrays;

public class Merge2ArrayList {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        int[] a = new int[m + n];
        if (m != 0) {
            for (int i = 0; i < m; i++) {
                a[i] = nums1[i];
            }
            int index = 0;
            for (int i = m; i < a.length && index < n; i++) {
                a[i] = nums2[index];
                index++;
            }
            Arrays.sort(a);
            nums1 = a;
        } else {
            nums1 = nums2;
        }
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 1; i <= n; i++) {
            nums1[m+i]=nums2[i-1];
            m++;
        }

        Arrays.sort(nums1);


    }



    public void merge3(int[] nums1, int m, int[] nums2, int n) {


//method 1
        // for (int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }
        // Arrays.sort(nums1);

//method2
        // int k = m + n;
        // int[] temp = new int[k];

        // // m有可能和n不相等
        // for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index++) {
        //     //nums1 数组取完了 完全取nums2的值
        //     if (nums1Index >= m) {
        //         temp[index] = nums2[nums2Index++];
        //     }
        //     //nums2 数组取完了 完全取nums1的值
        //     else if (nums2Index >= n) {
        //         temp[index] = nums1[nums1Index++];
        //     }
        //     //nums1 数组的元素小于 nums2的 取nums1数组的值
        //     else if (nums1[nums1Index] < nums2[nums2Index]) {
        //         temp[index] = nums1[nums1Index++];
        //     }
        //     //nums2 数组的元素小于等于 nums1左边数组 取nums2数组的值
        //     else {
        //         temp[index] = nums2[nums2Index++];
        //     }
        // }

        // for (int i = 0; i < k; i++) {
        //     nums1[i] = temp[i];
        // }

//method3
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

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};

        int[] b = new int[]{5, 2, 5};

        a = b;

        //System.out.println(a[0]);


        int m = 3;
        int n = 3;
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, m, nums2, n);


    }


}
