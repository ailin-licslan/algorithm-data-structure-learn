package com.licslan.interview.leetcode500.basestructure;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 中等
 * 927
 * 相关企业
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author licslan
 */
public class Lc113HasPathSum {


    //DFS

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> deque = new LinkedList<>();


    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum);
        return ret;

    }

    public void dfs(TreeNode root, int tarageSum) {
        if (root == null) return;

        //满足条件的放入队列
        deque.offerLast(root.val);

        tarageSum -= root.val;
        //正好找到了  没有叶子节点了  正好减到了0
        if (root.left == null && root.right == null && tarageSum == 0) {
            ret.add(new LinkedList<>(deque));
        }
        dfs(root.left, tarageSum);
        dfs(root.right, tarageSum);

        deque.pollLast();
    }

}
