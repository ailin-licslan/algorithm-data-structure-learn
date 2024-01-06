package com.licslan.interview.algorithmskills.array.prefixesarrays;

/**
 * 前缀和数组计算  快速计算子数组的之间的和   https://leetcode.cn/problems/range-sum-query-immutable/description/
 * 303. 区域和检索 - 数组不可变
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * <p>
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 *
 *
 * 适用场景： 元素数组不会被修改的情况下  频繁查询某个区间的累加和
 */
public class NumArray303 {




//    //方法一
//    private int[] nums;
//    public NumArray303(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int res = 0;
//        for (int i = left; i <= right; i++) {
//            res += nums[i];
//        }
//        return res;
//    }




    //方法二 前缀和数组
    private static int[] preSum;

    public NumArray303(int[] nums) {
        //初始化 preSum  preSum[0] = 0;
        preSum = new int[nums.length + 1];
        //给preSum数组每个元素赋值计算一下
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }


    // O(N)
    public static int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }


    public static void main(String[] args) {

        //学生成绩
        int[] scores = new int[]{100, 98, 98, 50};

        //分数区间 0-100   100+1
        int[] count = new int[101];

        //统计每个分数点的个数
        for (int score : scores) {
            count[score]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println("=========================");

        //return count[right] - count[left-1];

        //统计一个区间段里面学生的个数  比如 50分~100分里面有多少学生
        int i = count[100] - count[89];

        System.out.println(i);


    }


}
