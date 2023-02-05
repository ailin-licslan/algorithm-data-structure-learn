package com.licslan.interview.leetcode500.basestructure;

/**
 * @author licslan
 * 69. x 的平方根
 * 简单
 * 1.2K
 * 相关企业
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class X2Squar69 {


    //二分法

    public int mySqrt(int x) {


        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return index;

    }

    //牛顿迭代 (x/n+n)/2   x/n=n

    public int newTon(int x) {
        return (int) squart(x, x);
    }

    private double squart(double i, int x) {

        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return squart(res, x);
        }
    }

}
