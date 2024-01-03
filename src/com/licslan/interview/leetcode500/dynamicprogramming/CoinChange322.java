package com.licslan.interview.leetcode500.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 * 322. 零钱兑换
 * 中等
 * 2.7K
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * 动态规划  求最值  穷举
 * 1.状态转移方程  2.重复子问题  3.dp数组遍历顺序的确定  4.最优子结构  暴力 --> 自顶向下  ---> 自底向上 写
 */
public class CoinChange322 {


    //暴力递归方法
    public int coinChange1(int[] coins, int amount) {

        //base case
        if (amount == 0) return 0;
        if (amount < -0) return -1;


        int res = Integer.MAX_VALUE;

        for (int coin : coins) {

            //计算子问题
            int subTask = coinChange1(coins, amount - coin);

            //子问题无解  跳过
            if (subTask == -1) continue;

            //子问题选择最优解 再+1
            res = Math.min(res, subTask + 1);

        }

        return res == Integer.MAX_VALUE ? -1 : res;


    }


    //备忘录写法 过滤掉重复计算的数据  自顶向下递归写法

    int[] memo;


    public int coinChange(int[] coins, int amount) {

        memo = new int[amount + 1];

        Arrays.fill(memo, -111);

        return dp(coins, amount);


    }

    private int dp(int[] coins, int amount) {

        if (amount == 0) return 0;
        if (amount < 0) return -1;

        //查备忘录 防止重复计算
        if (memo[amount] != -111) {
            return memo[amount];
        }


        int res = Integer.MAX_VALUE;
        for (int coin : coins) {

            //计算子问题
            int subTask = dp(coins, amount - coin);

            if (subTask == -1) continue;

            res = Math.min(res, subTask + 1);


        }

        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;

        return memo[amount];

    }


    //自底向上
    private int coinChange2(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        //初始化一个特殊值  > 最大的可能性数值都可以
        Arrays.fill(dp, amount + 2);

        dp[0] = 0;

        //外侧遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {

            //内层遍历所有选择的最小值
            for (int coin : coins) {

                if (i - coin < 0) continue;
                //状态转移
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        //amount是否可以凑出来
        return (dp[amount] == amount + 2) ? -1 : dp[amount];

    }


}
