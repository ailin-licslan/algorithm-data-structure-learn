package com.licslan.interview.algorithmskills.binarytree;

import com.licslan.interview.hot100.utils.TreeNode;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 * 代码
 * <p>
 * 测试用例
 * 测试结果
 * 测试结果
 * <p>
 * 114. 二叉树展开为链表
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten114 {

    public void flatten(TreeNode root) {
        //BASE CASE
        if (root == null) return;

        //把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        //后序遍历位置

        //左右子树拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //将左子树作为右子树
        root.left = null;
        root.right = left;

        //将原先的右子树节点接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
