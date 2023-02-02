package com.licslan.interview.leetcode500.bitoperation;

import java.util.Arrays;

/**
 * @author licslan
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class CountBits338 {

    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //x = x&(x-1) 出现1的个数 清除最低位的1
            //参考思路 https://www.bilibili.com/video/BV11Y4y1q7YA?p=48&spm_id_
            //from=pageDriver&vd_source=bbb985ceadc8e3199d1d5a091b58155b
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }


    /**
     * 0 = 0 * 2^0             ---->0
     * 1 = 1 * 2^0             ---->1
     * 2 = 0 * 2^0 + 1 * 2^1   ---->01
     * 3 = 1 * 2^0 + 1 * 2^1   ---->11
     * 4 = 0 * 2^0 + 0 * 2^1 + 1 * 2^2   ---->001
     * 5 = 1 * 2^0 + 0 * 2^1 + 1 * 2^2   ---->101
     * // [0,1,1,2,1,2]
     * */


    public static void main(String[] args) {
        int[] ints = countBits(5);
        System.out.println("=============== "+ Arrays.toString(ints));
    }
}
