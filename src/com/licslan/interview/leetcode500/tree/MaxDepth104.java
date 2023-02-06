package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author licslan
 * LeetCode 专栏  ♥  NO104
 * 104. 二叉树的最大深度
 * 简单
 * 1.5K
 * 相关企业
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth104 {

    public int maxDepth(TreeNode root) {


        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }


    //BFS

    public int maxDepthWithQueue(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            //记录本层级的节点是否已经处理完
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }

        return depth;

    }


//     DFS 深度优先

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            max = Math.max(maxDepth2(root.left), max);
        }

        if (root.right != null) {
            max = Math.max(maxDepth2(root.right), max);
        }

        return max + 1;

    }


    //DFS

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
