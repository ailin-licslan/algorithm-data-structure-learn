package com.licslan.interview.hot100;

import java.util.Arrays;

/**
 * @author WEILIN
 * 比特位计数
 */
public class CountBits338 {
    public static int[] countBits(int n) {
        /**
         * 1. dp[i] = (第 i 个数的二进制)中 1 的个数
         * 2. 递推公式: 偶数: dp[i] = dp[i / 2]
         *              例如: 4 -> 100; 2 -> 10; 4 比 2 在低位多了个 0
         *                   10 -> 1010; 5 -> 101; 10 比 5 在低位多个 0, 两个数的 1 是相等的
         *             奇数: dp[i] = dp[i - 1] + 1    因为 奇数 比 (奇数 - 1)偶数 多 1
         * 3. dp数组初始化: dp[0] = 0
         * 4. 第一层 for : i = 1; i < dp.length; i++ // 从前往后
         * 5. 打印 dp
         *
         * 0 <= n <= 105
         * 位运算
         * 动态规划
         **/


        /**
         * 0 = 0 * 2^0             ---->0
         * 1 = 1 * 2^0             ---->1
         * 2 = 0 * 2^0 + 1 * 2^1   ---->01
         * 3 = 1 * 2^0 + 1 * 2^1   ---->11
         * 4 = 0 * 2^0 + 0 * 2^1 + 1 * 2^2   ---->001
         * 5 = 1 * 2^0 + 0 * 2^0 + 1 * 2^2   ---->101
         * */
        // 1. dp[i] = (第 i 个数的二进制)中 1 的个数
        int[] dp = new int[n + 1];

        // 3. dp数组初始化: dp[0] = 0    Java 默认是 0

        // 4. 第一层 for : i = 1; i < dp.length; i++ // 从前往后
        for (int i = 1; i < dp.length; i++) {
            if (i % 2 == 0) {
                // 2. 递推公式: 偶数: dp[i] = dp[i / 2]
                dp[i] = dp[i / 2];
            } else {
                // 奇数: dp[i] = dp[i - 1] + 1
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] ints = countBits(4);
        System.out.println(Arrays.toString(ints));
    }
}

