package com.licslan.interview.hot100;

/**
 * @author WEILIN
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列，因数学家莱昂纳多·斐波那契（Leonardo Fibonacci）
 * 以兔子繁殖为例子而引入，故又称为“兔子数列”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，
 * 斐波那契数列以如下被以递推的方法定义：F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）在现代
 * 物理、准晶体结构、化学等领域，斐波那契数列都有直接的应用，为此，美国数学会从 1963 年起出版了以《斐波那契
 * 数列季刊》为名的一份数学杂志，用于专门刊载这方面的研究成果。
 */
public class ClimbStairs70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
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
}
