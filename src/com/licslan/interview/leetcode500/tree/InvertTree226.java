package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * @author licslan
 * LeetCode 专栏  ♥  NO226
 */
public class InvertTree226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //将当前节点的左右子树交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);

        return root;
    }


}
