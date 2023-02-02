package com.licslan.interview.leetcode500.bitoperation;

/**
 * @author licslan
 * 461. 汉明距离
 * 简单
 * 668
 * 相关企业
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 */
public class HammingDistance461 {

    /**
     * 异或运算(^)是以二进制数据为基础进行运算的。也就是说当代码中使用到异或运算时，
     * 都会先将两个条件进行转换，转换成二进制数据后，再进行运算。
     * 异域中同位如果值相同(都是0或者都是1)则为0，不同(一个是0，一个是1)为1。
     * int a = 3
     * int b = 8
     * int c =a^b
     * 运算过程
     * 3的二进制是 0000  0011
     * 8的二进制是 0000  1000
     * 异或的结果:  0000  1011   转换之后结果为11。
     * 扩展：二进制转换为十进制：
     * 0000 1011去掉补齐的高位是 1011
     * 1011  = 1x2^3 + 0x2^2 + 1x2^1 + 1x2^0=11
     * 去掉补齐的高位 0000
     * 1：0x2^3 + 0x2^2 + 0x2^1 + 1x2^0 --> 0001
     * 4：0x2^3 + 1x2^2 + 0x2^1 + 0x2^0 --> 0100
     * 1 --> 0000 0001
     * 4 --> 0000 0100
     * 1 ^ 4 0000 0101  --> 十进制后 0x2^3 + 1x2^2 + 0x2^1 + 1x2^0 = 5
     */
    public static int hammingDistance(int x, int y) {
        // ^异运算  1^4 = 5 --> 0000 0101
        int j = x ^ y;
        // 转换成二进制  "101"
        String string = Integer.toBinaryString(j);
        char[] chars = string.toCharArray();
        int i = 0;
        // char是基本数据类型，直接用==就可以进行比较  异或时只要判断里面==1 就行 一样的时都是0 找出==1 的个数即可
        for (char a : chars) {
            if (a == '1') {
                i++;
            }
        }
        return i;
    }


    //x = x&(x-1) 清除最低位的1 可以知道 里面有几个1 出现1 的次数

    public static int hammingDistance2(int x, int y) {

        int distance = 0;
        for (int xor = x ^ y; xor != 0; xor &= (xor - 1)) {
            distance++;
        }
        return distance;
    }


}
