package com.licslan.interview.algorithmskills.backtrack;

import java.util.LinkedList;
import java.util.List;


/**
 * https://leetcode.cn/problems/permutations/description/
 * 46. 全排列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Permute46 {

    //存储全排列结果
    List<List<Integer>> res = new LinkedList<>();

    //输入一组不重复的数组  返回他们的全排列结果
    public List<List<Integer>> permute(int[] nums) {

        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);

        return res;
    }

    //回溯算法模板
    private void backtrack(int[] nums, LinkedList<Integer> track) {

        //到达叶子节点 将路径转入结果列表
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 遍历
        for (int num : nums) {
            //排除不合法的
            if (track.contains(num)) {
                continue;
            }

            //做选择
            track.add(num);
            //进入下一个决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }


    }
}
