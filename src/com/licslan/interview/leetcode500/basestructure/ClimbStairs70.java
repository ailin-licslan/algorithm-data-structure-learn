package com.licslan.interview.leetcode500.basestructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WEILIN
 * 专栏  ♥  NO70
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


    // method1 循环写法

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];


        //注意爬楼梯 这里都是1  而509里面一个是0,dp[0] = 0  一个是1,dp[1] = 1
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



    // 置底向上不断累加

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int result = 0;

        for (int i = 3; i < n; i++) {

            result = pre + prePre;
            prePre = pre;
            pre = result;

        }
        return result;

    }

    //method2
    //f(n) =1 n=1 [1 走一步], f(n)=2 n=2  [1+1 每次走一步,2 一次走两步], f(n)=f(n-1)+f(n-2) n>3
    //递归写法  leetcode 超时判题 重复计算

    public static int climbStairs2(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }


    //method2 改进型
    //f(n) =1 n=1 [1 走一步], f(n)=2 n=2  [1+1 每次走一步,2 一次走两步], f(n)=f(n-1)+f(n-2) n>3
    //递归写法  置顶向下计算  f(n)=f(n-1)+f(n-2)

    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairsByMap(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.get(n) != null) {
            return map.get(n);
        } else {
            //递归计算
            int result = climbStairsByMap(n - 1) + climbStairsByMap(n - 2);
            //计算出来的值先存一下  避免后续重复计算  O(m)
            map.put(n, result);
            return result;
        }

    }


    public static void main(String[] args) {

        int i = climbStairs2(45);
        System.out.println(i);
    }

}
