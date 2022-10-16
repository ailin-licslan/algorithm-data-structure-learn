package com.licslan.interview.hot100;

import java.util.Arrays;

/**
 * @author WEILIN
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber136 {



    //思路 先排序  遍历时 加一个  减一下  剩下的最后元素就是不重复的元素

    public static int singleNumber(int[] nums) {

        //排序一下
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {

            //偶数序
            if (i % 2 == 0) {
                res += nums[i];
            } else {
                //奇数序
                res -= nums[i];
                if (res != 0) {
                    res = nums[i - 1];
                    break;
                }
            }
        }


        return res;
    }


    public static void main(String[] args) {

        int[] a = new int[]{2,2,3,6,4,4,3};

        int i = singleNumber(a);
        System.out.println(i);

    }
}
