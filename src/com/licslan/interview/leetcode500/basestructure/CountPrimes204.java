package com.licslan.interview.leetcode500.basestructure;

import java.util.Arrays;

/**
 * @author licslan
 * leetcode 204  统计n以内素数个数
 * <p>
 * 204. 计数质数
 * 中等
 * 1K
 * 相关企业
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 */
public class CountPrimes204 {


    //超时

    public static int isPrimeTest(int n) {
        //0 1 排除
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        //i<根号m 减少一半的判断
        int max = (int) Math.sqrt(x);
        for (int i = 2; i <= max; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    //埃筛法

    public static int countPrimes(int n) {

        //默认全部是素数
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }



    //越界问题

    public static int countPrimes2(int n) {
        //默认全部是素数 默认false
        boolean[] isPrim = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 如果当前是素数
            if (!isPrim[i]) {
                count ++;
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = true;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //2357 countPrimes
        System.out.println(countPrimes2(499979));
        //System.out.println(countPrimes(100));
    }
}










