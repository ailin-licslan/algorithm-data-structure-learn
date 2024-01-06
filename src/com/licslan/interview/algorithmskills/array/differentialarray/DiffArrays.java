package com.licslan.interview.algorithmskills.array.differentialarray;

/**
 * 差分数组：  适用场景 频繁对原始数组的某个区间的元素进行增减
 */
public class DiffArrays {


    //差分数组定义
    private int[] diff;


    //输入一个数组 区间操作在这个数组上进行  根据初始数组计算差分数组
    public DiffArrays(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }


    //给区间[i,j]的元素都增加val 正负数都可以  再还原原始数组时 就相当于给区间 [i,j]每个元素 增加 val了 只需要改动2个数diff[i] diff[j+1] 就可以 不需要去遍历改动个元素
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }


    //还原计算后的数组
    public int[] result() {
        int[] res = new int[diff.length];
        //根据差分数组还原原始数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }


}
