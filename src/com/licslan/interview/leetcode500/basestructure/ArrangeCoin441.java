package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 441. 排列硬币
 * 简单
 * 257
 * 相关企业
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * <p>
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 */
public class ArrangeCoin441 {


    //迭代

    public static int arrangeCoins(int n) {

        for (int i = 1; i <= n; i++) {
            //放完一排剩余多少
            n = n - i;
            //如果下一次需要放的硬币数量大于 这个剩余的数据 直接返回放了几排的 i
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

    //二分查找  [1,N] 找到x   超时

    public static int arrangeCoins2(int n) {

        int low = 0, high = n;
        //1....x 求和 数学公式  (x^2 + x)/2
        while (low <= high) {
            //放了多少行数
            int mid = (high - low) / 2 + low;
            int cost = ((mid + 1) * mid) / 2;
            //找到了目标
            if (cost == n) {
                return mid;
            } else if (cost > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }


    //1....x 求和 数学公式  (m^2+m)/2
    //牛顿迭代 (x+n/x)/2      m^2+m  => (m^2+m)/2 =n  m^2+m=2n  m^2 = 2n -m  m=根号2n-m
    //将m带入   (x+n/x)/2 中的n中


    //stack over flow Error

    public static int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) squart(n, n);
    }

    private static double squart(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        } else {
           return squart(res, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
        System.out.println(arrangeCoins2(1804289383));
    }

}
