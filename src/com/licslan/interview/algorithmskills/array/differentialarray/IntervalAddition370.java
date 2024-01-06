package com.licslan.interview.algorithmskills.array.differentialarray;

/**
 * https://leetcode.cn/problems/range-addition/description/  会员题
 * 区间加法 370
 * <p>
 * length=5 [0,0,0,0,0]  updates = [[1,3,2],[2,4,3],[0,2,-2]]  输出 [-2,0,3,5,3]
 */
public class IntervalAddition370 {


    int[] getModifiedArray(int length, int[][] updates) {

        int[] nums = new int[length];
        //构造差分数组
        DiffArrays df = new DiffArrays(nums);

        for (int[] update : updates) {
            //区间 i
            int i = update[0];
            //区间 j
            int j = update[1];
            //每次操作变化多少
            int val = update[2];
            df.increment(i, j, val);
        }
        return df.result();
    }


}
