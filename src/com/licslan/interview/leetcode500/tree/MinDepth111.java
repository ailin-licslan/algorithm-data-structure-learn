package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author licslan
 * LeetCode 专栏  ♥  NO111
 * 111. 二叉树的最小深度
 * 简单
 * 911
 * 相关企业
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepth111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }

        int h1 = minDepth(root.left);
        int h2 = minDepth(root.right);

        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        if (root.left == null || root.right == null) {
            return h1 + h2 + 1;
        }

        //3.左右都不为空 返回最小深度+1
        return Math.min(h1, h2) + 1;

    }


    //DFS 深度优先写法

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth2(root.left), min);
        }

        if (root.right != null) {
            min = Math.min(minDepth2(root.right), min);
        }

        return min + 1;

    }


    //BFS  广度优先写法

    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.deep;
            }
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }

        return 0;

    }


}
