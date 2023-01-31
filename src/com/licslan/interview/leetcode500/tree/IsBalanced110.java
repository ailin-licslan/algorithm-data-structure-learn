package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author licslan
 * LeetCode 专栏  ♥  NO110
 * 110. 平衡二叉树
 * 简单
 * 1.2K
 * 相关企业
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;

    }

    private int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }
}
