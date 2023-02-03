package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 剑指 Offer 10- I. 斐波那契数列  同leetcode 509写法  同爬楼梯题目70
 * 简单
 * 434
 * 相关企业
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 */
public class JianZhiOffer10 {
    public int fib(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        final int MOD = 1000000007;
        int res = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            res = (pre + prePre) % MOD;
            prePre = pre;
            pre = res;
        }

        return res;
    }


    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        //从2 开始推到  F(n)=F(n - 1)+F(n - 2)
        for (int i = 2; i <= n; i++) {

            //when i = 2  dp[1]+dp[0] = 2 = dp[2]
            //when i = 3  dp[2]+dp[1] = 2+1 = 3 dp[3]
            //when i = 4  dp[3]+dp[2] = 3+2 = 5 dp[4]

            //......
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }



}
