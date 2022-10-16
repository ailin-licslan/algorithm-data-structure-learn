package com.licslan.interview.hot100;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author WEILIN
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree226 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        inverse(root);
        return root;

    }

    public void inverse(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        inverse(node.left);
        inverse(node.right);

    }

}
