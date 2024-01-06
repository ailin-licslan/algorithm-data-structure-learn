package com.licslan.interview.algorithmskills.binarytree;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * https://leetcode.cn/problems/invert-binary-tree/submissions/493429517/
 *
 * 226. 翻转二叉树
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * */
public class InvertTree226 {


    //遍历问题
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    //分解问题的思路
    public TreeNode invertTree2(TreeNode root) {

        if (root == null) return null;

        //先反转左右子树

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        //交互左右子树节点
        root.left = right;
        root.right = left;

        return root;

    }

}
