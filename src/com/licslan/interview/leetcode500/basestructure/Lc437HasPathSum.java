package com.licslan.interview.leetcode500.basestructure;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 437. 路径总和 III
 中等
 1.6K
 相关企业
 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。


 *
 * @author licslan
 */
public class Lc437HasPathSum {


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }



/***
 非根节点开始  只要里面有满足从上往下几个节点加起来的值等于目标值
 分别将每个结点作为开始结点，寻找所有结点值总和等于目标和的路径。寻找路径的做法是，
 在开始结点为根结点的子树中深度优先搜索，假设开始结点值为 val，
 则对于开始结点的每个非空子树，子树中的每一条结点值总和等于
 targetSum−val 的路径都对应从开始结点出发的一条结点值总和等于targetSum 的路径

 如果根结点值等于目标和，则以根结点为结束结点的路径为结点值总和等于目标和的路径，将路径数目加 1；
 如果根结点值不等于目标和，则路径数目不变。

 对左子树和右子树递归地计算路径数目。

 */

        //根节点的左右节点开始算
        int count = countPaths(root, targetSum);

        //从根节点里面的左右子树开始算 迭代的去搜索
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    public int countPaths(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val == targetSum) {
            count++;
        }
        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);
        return count;
    }

}
