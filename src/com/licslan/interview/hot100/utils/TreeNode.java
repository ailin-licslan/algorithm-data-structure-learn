package com.licslan.interview.hot100.utils;

/**
 * @author WEILIN
 * 94中序遍历
 * 定义树
 */

public class TreeNode {

    /**
     * 树节点的值
     */
    public int val;

    /**
     * 左子树
     */
    public TreeNode left;

    /**
     * 右子树
     */
    public TreeNode right;

    /**
    leetcode 111
    */
    public int deep;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
