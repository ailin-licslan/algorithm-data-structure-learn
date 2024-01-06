package com.licslan.interview.algorithmskills.array.differentialarray;

/**
 * https://leetcode.cn/problems/car-pooling/description/
 * 1094. 拼车
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */
public class CarPooling1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] nums = new int[1001];
        // 构造差分数组
        DiffArrays df = new DiffArrays(nums);

        for (int[] trip : trips) {
            // 区间 i
            int val = trip[0];
            // 区间 j
            int i = trip[1];
            // 每次操作变化多少  计算时下车前一站 没有下车的载重量
            int j = trip[2] - 1;
            df.increment(i, j, val);
        }
        int[] res = df.result();

        for (int re : res) {
            if (capacity < re) {
                //超载
                return false;
            }
        }
        return true;
    }
}
