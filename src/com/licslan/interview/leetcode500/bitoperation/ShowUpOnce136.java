package com.licslan.interview.leetcode500.bitoperation;

import java.util.Arrays;

/**
 * @author licslan
 * 136. 只出现一次的数字
 * 简单
 * 2.7K
 * 相关企业
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class ShowUpOnce136 {

    public static int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            //自己与自己异或 为0  出现2次相同的数会抵消掉
            result = result ^ num;
        }
        return result;
    }


    //思路 先排序  遍历时 加一个  减一下  剩下的最后元素就是不重复的元素

    public static int singleNumber2(int[] nums) {
        //排序一下
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //偶数序  /*i % 2 == 0*/
            if ((i & 1) == 0) {
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
        int[] a = new int[]{1, 1, 2, 3, 3, 2, 10};
        System.out.println(singleNumber(a));
    }

}
