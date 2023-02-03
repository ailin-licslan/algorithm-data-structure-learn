package com.licslan.interview.leetcode500.dynamicprogramming;

import java.util.Random;

/**
 * @author licslan
 * leetcode 470 中等
 * <p>
 * 470. 用 Rand7() 实现 Rand10()
 * 中等
 * 435
 * 相关企业
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * <p>
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * <p>
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [3,8,10]
 */
public class Rand470 {

    //1.rand7 1~7
    //2.rand7-1  0~6
    //3.(rand7-1)*7 0,7,14,21,28,35,42
    //4.(rand7-1)*7 + rand7-1 (0~48)
    //5.check step4 排除>=40
    //6. mod 10 +1

    public static int rand10() {

        int temp = 40;

        while (temp >= 40) {

            temp = (rand7() - 1) * 7 +rand7()-1;
        }
        return temp % 10 + 1;
    }


    //思路拓展
    //拓展 randN[3] --> randM[11]   x>=M  x[22] 是N的整数倍数
    //rand3 ---> rand11
    //1.rand3 1 2 3
    //2.rand3-1 0 1 2
    //3.(rand3-1)*3 0 3 6
    //4.(rand3-1)*3*3 0 9 18
    //5.(rand3-1)*3*3+  (rand3-1)*3 +  rand3-1 = [0,26]
    //6.check step 5 result >=22 loop step5
    //7.mod 11 +1   ========> 1~11 ==> rand11









    public static int rand7() {
        Random random = new Random();
        return random.nextInt(7);
    }

    public static void main(String[] args) {
        System.out.println(rand10());
    }
}
