package com.licslan.interview.algorithmskills.array.differentialarray;

/**
 * 1109. 航班预订统计   https://leetcode.cn/problems/corporate-flight-bookings/description/
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * */
public class CorpFlightBookings1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] nums = new int[n];
        // 构造差分数组
        DiffArrays df = new DiffArrays(nums);

        for (int[] update : bookings) {
            // 区间 i
            int i = update[0] - 1;
            // 区间 j
            int j = update[1] - 1;
            // 每次操作变化多少
            int val = update[2];
            df.increment(i, j, val);
        }
        return df.result();

    }
}
