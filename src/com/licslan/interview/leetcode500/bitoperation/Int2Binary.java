package com.licslan.interview.leetcode500.bitoperation;

/**
 * @author licslan
 */
public class Int2Binary {

    public static void main(String[] args) {
        //第一位0 正数  第一位1 负数


        System.out.println("4 is ==>  " + Integer.toBinaryString(4));
        System.out.println("6 is ==>  " + Integer.toBinaryString(4));
        //& 位与运算  1&1=1 0&0=0 1&0=0
        System.out.println("4$6 is ==>  " + Integer.toBinaryString(4 & 6));
        //| 位或运算 1|1=1 0|0=0 1|0=1
        System.out.println("4|6 is ==>  " + Integer.toBinaryString(4 | 6));
        //~ 位非
        System.out.println("~6 is ==>  " + Integer.toBinaryString(~6));
        //^位异或 1^1=1 1^0=1 0^0=0
        System.out.println("4^6 is ==>  " + Integer.toBinaryString(4 ^ 6));
        System.out.println("6^6 is ==>  " + Integer.toBinaryString(6 ^ 6));


        System.out.println("-20 is ==>" + Integer.toBinaryString(-20));

        //有符号右移动  正数 高位补0 负数高位补1
        System.out.println("4>>1 is ==>" + Integer.toBinaryString(4 >> 1));
        System.out.println("-20>>1 is ==>" + Integer.toBinaryString(-20 >> 1));

        //有符号左移动  正数 高位补0 负数高位补1
        System.out.println("-234567<<16 is ==>" + Integer.toBinaryString(-234567 << 16));


        //无符号右移动[>>>]  不论正负高位补0
        System.out.println("234567>>>4 is ==>" + Integer.toBinaryString(-234567 >>> 4));

        //无符号右移动[>>>]  不论正负高位补0
        System.out.println("-4" + Integer.toBinaryString(-4));
        System.out.println("-4>>>4 is ==>" + Integer.toBinaryString(-4 >>> 4));
        System.out.println("-4>>4 is ==>" + Integer.toBinaryString(-4 >> 1));


        int[] a = new int[4];
        int[] b = new int[(a.length >> 1) + a.length];
        //缩小一半 >>1 1/2  翻倍 <<1 x2
        System.out.println("b-len-is ===>" + ((a.length << 1) + a.length) + ", b size is===>" + b.length);

        //位运算常用场景
        //1.取模 2.判断奇偶数 3.实现数字翻倍或减半 4.交换2个数

        //4.交换
        int c = 7, d = 8;
        c = c ^ d;
        d = c ^ d;
        c = c ^ d;
        System.out.println("c,d " + c + "-" + d);

        int odd = 4;
        if ((odd & 1) == 0) {
            System.out.println("odd 是 偶数");
        }
        if ((d & 1) != 0) {
            System.out.println("c 是 奇数");
        }

    }
}
