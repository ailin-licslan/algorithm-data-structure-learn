package com.licslan.interview.leetcode500.dynamicprogramming;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 同 爬楼梯 leetcode70
 */
public class Fib509 {

    public int fib(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        int res = 0;
        int pre = 1;
        int prePre = 0;
        for (int i = 2; i <= n; i++) {
            res = pre + prePre;
            prePre = pre;
            pre = res;
        }

        return res;
    }



    //DP 写法

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        //从2 开始推到  F(n)=F(n - 1)+F(n - 2)
        for (int i = 2; i <= n; i++) {
            //when i = 2  dp[1]+dp[0] = 2 = dp[2]
            //when i = 3  dp[2]+dp[1] = 2+1 = 3 dp[3]
            //when i = 4  dp[3]+dp[2] = 3+2 = 5 dp[4]

            //......
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib2(5));
    }
}
