package com.licslan.interview.hot100;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WEILIN
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 * 先序遍历  一个节点是根节点开始  先根节点  左子树  右子树
 * 中序遍历  先左子树  根节点  右子树
 * 后序遍历  先左子树  右子树 根节点
 */
public class InOrderTraversal94 {

    List<Integer> res = new LinkedList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {

        //1 root 2  lift  3 right
        if (root != null) {
            inOrderTraversal(root);
            res.add(root.val);
            inOrderTraversal(root.right);
        }

        return res;
    }


}
